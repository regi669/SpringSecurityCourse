package com.regi.SpringSecurityCourse.security;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.regi.SpringSecurityCourse.security.AppUserPermission.*;

public enum AppUserRole {
    ADMIN(Sets.newHashSet(WRITE, READ, UPDATE)), //index 0 in db
    USER(Sets.newHashSet(READ));                 //index 1 in db

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }

    /*
    * When we want to add role and not permission we need to add ROLE_ to the role name
    * in order for spring security to recognize it as a role from permissions set
    * this.name() returns the name of AppUserRole enum connected with choosen user
    * */
    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
