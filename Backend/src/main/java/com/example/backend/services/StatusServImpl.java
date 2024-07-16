package com.example.backend.services;

import com.example.backend.entities.HostEntity;
import com.example.backend.enums.Hoststatus;
import com.example.backend.Exceptions.InternalServerErrorException;
import com.example.backend.repositories.HostRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StatusServImpl implements StatusService {

    private final HostRepository hostRepository;

    @Override
    @Scheduled(fixedRate = 20000) // Schedule to run every 20 seconds
    public void checkStatuses() {
        try {
            List<HostEntity> hosts = hostRepository.findAll();

            for (HostEntity host : hosts) {
                Hoststatus status = isHostUp(host) ? Hoststatus.UP : Hoststatus.DOWN;
                log.info("Host {} ({}:{}) is {}", host.getId(), host.getIp(), host.getPort(), status);
                // Here, you could also store the status in a database or update an in-memory status map
            }
        } catch (Exception e) {
            log.error("Error retrieving hosts or checking statuses", e);
            throw new InternalServerErrorException("Error retrieving hosts or checking statuses");
        }
    }

    private boolean isHostUp(HostEntity host) {
        try (Socket socket = new Socket()) {
            SocketAddress socketAddress = new InetSocketAddress(host.getIp(), host.getPort());
            socket.connect(socketAddress, 2000); // 2 seconds timeout
            return true;
        } catch (IOException e) {
            log.error("Error connecting to host {}:{}", host.getIp(), host.getPort(), e);
            return false;
        }
    }
}
