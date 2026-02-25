package com.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode( of = "storeId")
@ToString(exclude = {"employees", "invoices", "deliveries"})
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "store_id", nullable = false)
    private UUID storeId;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_address", nullable = false)
    private String storeAddress;

    @Column(name = "store_description")
    private String storeDescription;

    @Column(name = "store_image_url")
    private String storeImageUrl;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @OneToMany(mappedBy = "store")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Invoice> invoices = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Delivery> deliveries = new ArrayList<>();
}
