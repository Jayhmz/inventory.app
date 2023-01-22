package com.plantacion.inventory.app.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_id", nullable = true, unique = true)
    private String asset_Id;

    @Column(name = "asset_name", nullable = false)
    private String asset_Name;

    @Column(name = "asset_category", nullable = false)
    private String asset_Category;

    @Column(name = "asset_location", nullable = false)
    private String asset_Location;

    @Column(name = "asset_user", nullable = false)
    private String asset_User;

    @Column(name = "asset_serial_no", nullable = true, unique = true)
    private String asset_Serial_No;

    @Column(name = "new_asset_id", nullable = false, unique = true)
    private String new_AssetId;

    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "movement_details", nullable = true)
    private String movement_Details;
    @Column(name = "availability_details", nullable = false)
    private String availability_Details;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AssetComponent> components;

}
