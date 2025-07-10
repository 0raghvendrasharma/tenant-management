package com.raghvendra.tenant_management.repository;

import com.raghvendra.tenant_management.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Tenant findByEmail(String email);

    Optional<Tenant> findByEmailAndPassword(String email, String password);
}
