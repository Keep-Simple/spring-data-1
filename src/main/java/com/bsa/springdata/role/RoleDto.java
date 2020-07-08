package com.bsa.springdata.role;

import lombok.Builder;

import java.util.UUID;

@Builder
public class RoleDto {
    private final UUID id;
    private final String name;
    private final String code;

    public static RoleDto fromEntity(Role role) {
        return RoleDto
                .builder()
                .id(role.getId())
                .name(role.getName())
                .code(role.getCode())
                .build();
    }
}
