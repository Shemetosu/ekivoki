package com.itgroup.data.scheduler;

import com.itgroup.data.repository.dao.GameSessionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Component
public class GameSessionScheduler {

    private final GameSessionRepository repository;

    @Scheduled(fixedDelay = 1000 * 60, initialDelay = 1000 * 10)
    public void removeOldSessions() {
        int count = repository.removeOldSessions(LocalDateTime.now().minusDays(1));
        if (count > 0) {
            log.info(count == 1 ? "Была удалена {} старая сессия" : "Было удалено {} старых сессий", count);
        }
    }
}
