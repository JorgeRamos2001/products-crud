package com.api.repositories;

import com.api.models.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    List<Delivery> findAllByStore_StoreId(UUID storeId);
    List<Delivery> findAllByEmployee_EmployeeId(UUID employeeId);
}
