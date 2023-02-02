package com.plantacion.inventory.app.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "new_assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_id", nullable = true)
    private String asset_Id;

    @Column(name = "asset_name", nullable = false)
    private String asset_Name;

    @Column(name = "asset_category", nullable = false)
    private String asset_Category;

    @Column(name = "asset_location", nullable = false)
    private String asset_Location;

    @Column(name = "asset_user", nullable = false)
    private String asset_User;

    @Column(name = "asset_serial_number", nullable = true)
    private String asset_Serial_No;

    @Column(name = "new_asset_id", nullable = false, unique = true)
    private String new_AssetId;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "asset")
    private Component component;

    @Column(name = "status", nullable = true)
    private String status;
    @Column(name = "asset_movement_details", nullable = true)
    private String movement_Details;
    @Column(name = "asset_availability_details", nullable = true)
    private String availability_Details;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date created_on;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updated_on;
}
