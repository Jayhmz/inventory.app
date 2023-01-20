package com.plantacion.inventory.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AssetComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String component_Id;
    private String component_Name;
    private String component_Category;
    private String new_ComponentId;

}
