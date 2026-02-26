package com.api.repositories;

import com.api.models.entities.Employee;
import com.api.models.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByDui(String dui);
    boolean existsByDui(String dui);
    List<Employee> findAllByStore_StoreId(UUID storeStoreId);
}
