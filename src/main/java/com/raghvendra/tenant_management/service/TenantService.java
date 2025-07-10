package com.raghvendra.tenant_management.service;


import com.raghvendra.tenant_management.entity.Tenant;
import com.raghvendra.tenant_management.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Optional<Tenant> getTenantById(Long id) {
        return tenantRepository.findById(id);
    }

    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Optional<Tenant> updateTenant(Long id, Tenant tenantDetails) {
    return tenantRepository.findById(id).map(tenant -> {
        if (tenantDetails.getName() != null) {
            tenant.setName(tenantDetails.getName());
        }
        if (tenantDetails.getEmail() != null) {
            tenant.setEmail(tenantDetails.getEmail());
        }
        if (tenantDetails.getRole() != null) {
            tenant.setRole(tenantDetails.getRole());
        }
        return tenantRepository.save(tenant);
        });
    }

    public boolean deleteTenant(Long id) {
        if (tenantRepository.existsById(id)) {
            tenantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

