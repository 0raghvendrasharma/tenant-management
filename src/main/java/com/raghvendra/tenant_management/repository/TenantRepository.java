package com.raghvendra.tenant_management.repository;

import com.raghvendra.tenant_management.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    
    Tenant findByEmail(String email);
}