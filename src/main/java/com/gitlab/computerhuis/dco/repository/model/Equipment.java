package com.gitlab.computerhuis.dco.repository.model;

import com.gitlab.computerhuis.dco.enumeration.EquipmentCategoryType;
import com.gitlab.computerhuis.dco.enumeration.EquipmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentCategoryType category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    private String manufacturer;
    private String model;

    private String specification;
    private Long customerId;

}
