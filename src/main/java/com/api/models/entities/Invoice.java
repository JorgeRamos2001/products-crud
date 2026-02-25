package com.api.models.entities;

import com.api.models.enums.InvoiceStates;
import com.api.models.enums.InvoiceTypes;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode( of = "invoiceId")
@ToString(exclude = {"store", "employee", "customer", "invoiceDetails", "delivery"})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "invoice_id", nullable = false)
    private UUID invoiceId;

    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_type", nullable = false)
    private InvoiceTypes invoiceType;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "discount")
    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_state", nullable = false)
    private InvoiceStates invoiceState;

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime invoiceDate;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetails> invoiceDetails = new ArrayList<>();

    @OneToOne(mappedBy = "invoice")
    private Delivery delivery;
}
