package ru.mariaccord.votingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @NotBlank(message = "Поле 'имя ресторана' не может быть пустым")
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", enabled=" + enabled +
                ", id=" + id +
                '}';
    }
}
