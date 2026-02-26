package com.api.repositories;

import com.api.models.entities.EmployeeContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeContractRepository extends JpaRepository<EmployeeContract, UUID> {
    Optional<EmployeeContract> findByEmployee_EmployeeId(UUID employeeEmployeeId);
}
