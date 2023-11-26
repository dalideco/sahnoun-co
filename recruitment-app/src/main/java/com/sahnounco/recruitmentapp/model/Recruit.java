package com.sahnounco.recruitmentapp.model;

public class Recruit {

    private Long id;
    private String name;
    private String position;

    public Recruit() {
        // Default constructor required for Jackson JSON mapping
    }

    public Recruit(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
