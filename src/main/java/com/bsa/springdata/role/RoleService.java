package com.bsa.springdata.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void deleteRole(String roleCode) {
        // TODO: Use a single query
        roleRepository.deleteByCodeIfNoUsers(roleCode);
    }
}
