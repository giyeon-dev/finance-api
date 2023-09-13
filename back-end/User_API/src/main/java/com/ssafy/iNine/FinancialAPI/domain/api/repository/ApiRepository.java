package com.ssafy.iNine.FinancialAPI.domain.api.repository;

import com.ssafy.iNine.FinancialAPI.common.entity.user.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApiRepository extends JpaRepository<ServiceProvider, Long> {

    @Query("SELECT s.apiToken FROM ServiceProvider s WHERE s.serviceProviderId=:serviceProviderId AND s.isDeleted=false")
    Optional<ServiceProvider> findByEmail(@Param("serviceProviderId") String serviceProviderId);

    @Modifying
    @Query("UPDATE ServiceProvider s SET s.apiToken = :apiToken WHERE s.serviceProviderId = :serviceProviderId")
    void modifyPassword(@Param("serviceProviderId") Long serviceProviderId, @Param("apiToken") String apiToken);
}
