package com.example.springsecuritydemo.security;

public enum ApplicationUserPermission {
    MEMBER_READ("member:read"),
    MEMBER_WRITE("member:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
