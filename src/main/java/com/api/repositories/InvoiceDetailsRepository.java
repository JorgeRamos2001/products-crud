package com.api.repositories;

import com.api.models.entities.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, UUID> {
    List<InvoiceDetails> findAllByInvoice_InvoiceId(UUID invoiceId);
}
