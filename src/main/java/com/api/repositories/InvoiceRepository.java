package com.api.repositories;

import com.api.models.entities.Invoice;
import com.api.models.enums.InvoiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);
    List<Invoice> findAllByInvoiceType(InvoiceTypes invoiceType);
    List<Invoice> findAllByStore_StoreId(UUID storeId);
    List<Invoice> findAllByEmployee_EmployeeId(UUID employeeId);
    List<Invoice> findAllByCustomer_CustomerId(UUID customerId);
}
