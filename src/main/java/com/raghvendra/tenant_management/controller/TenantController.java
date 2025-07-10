package com.raghvendra.tenant_management.controller;


import com.raghvendra.tenant_management.entity.Tenant;
import com.raghvendra.tenant_management.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "*") 
public class TenantController {

    @Autowired
    private TenantService tenantService;

    //Fetch tenants
    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        return ResponseEntity.ok(tenantService.getAllTenants());
    }

    //Fetch by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Optional<Tenant> tenant = tenantService.getTenantById(id);
        return tenant.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    //Create new
    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        Tenant savedTenant = tenantService.createTenant(tenant);
        return ResponseEntity.ok(savedTenant);
    }

    //Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant tenantDetails) {
        Optional<Tenant> updatedTenant = tenantService.updateTenant(id, tenantDetails);
        return updatedTenant.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }

    //Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id) {
        boolean deleted = tenantService.deleteTenant(id);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}
