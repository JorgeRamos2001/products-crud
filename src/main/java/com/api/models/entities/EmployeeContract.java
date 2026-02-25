package com.api.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employee_contracts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode( of = "employeeContractId")
@ToString(exclude = "employee")
public class EmployeeContract {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID employeeContractId;

    @Column(name = "contract_type", nullable = false)
    private String contractType;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
