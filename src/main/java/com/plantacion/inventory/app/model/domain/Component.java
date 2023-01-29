package com.plantacion.inventory.app.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "components")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "component_id", nullable = true)
    private String component_Id;

    @Column(name = "component_name", nullable = true)
    private String component_Name;

    @Column(name = "component_serial_no", nullable = true)
    private String component_Serial_No;

    @Column(name = "new_component_id", nullable = true)
    private String new_ComponentId;

    @Column(name = "status", nullable = true)
    private String status;
    @Column(name = "movement_details", nullable = true)
    private String movement_Details;
    @Column(name = "availability_details", nullable = true)
    private String availability_Details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date created_on;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false, updatable = false)
    private Date updated_on;

}
