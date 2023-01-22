package com.plantacion.inventory.app.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "components")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "component_id", nullable = false)
    private String component_Id;

    @Column(name = "component_name", nullable = false)
    private String component_Name;
    
    @Column(name = "component_category", nullable = false)
    private String component_Category;

    @Column(name = "component_location", nullable = false)
    private String component_Location;

    @Column(name = "component_serial_no", nullable = true, unique = true)
    private String component_Serial_No;

    @Column(name = "new_component_id", nullable = false, unique = true)
    private String new_ComponentId;

    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "movement_details", nullable = true)
    private String movement_Details;
    @Column(name = "availability_details", nullable = false)
    private String availability_Details;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_id")
    private Asset asset;

}
