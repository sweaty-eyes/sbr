package com.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString(exclude = {"lastTouched","creationDate"})
@MappedSuperclass
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @UpdateTimestamp
    private LocalDate lastTouched;
    @CreationTimestamp
    private LocalDate creationDate;

    public void setId(String id) {
        this.id = UUID.fromString(id);

    }
}
