package com.company;

public class A {
    private String name;
    private String role;
    private int level;

    public A() {

    }

    public A(String name, String role, int level) {
        setName(name);
        setRole(role);
        setLevel(level);
    }

    @Override
    public String toString() {
        return "name=" + this.name + "\nrole=" + this.role + "\nlevel=" + this.level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}