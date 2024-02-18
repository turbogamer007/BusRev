package com.busRev.repository;

import com.busRev.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {
    public CurrentUserSession findByUuid(String uuid);
}
