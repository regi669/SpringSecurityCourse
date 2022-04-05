package com.regi.SpringSecurityCourse.security;

public enum AppUserPermission {
    WRITE("write"),
    READ("read"),
    UPDATE("update");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
