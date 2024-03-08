package com.github.computerhuis.dco.repository.model;

import com.github.computerhuis.dco.enumeration.FormFactorType;
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
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormFactorType formFactor;
    private String manufacturer;
    private String model;
    private String specification;
    private Long personId;
    private Long companyId;

    public String getFormFactorName() {
        if (formFactor != null) {
            return formFactor.getLabel();
        }
        return null;
    }
}
