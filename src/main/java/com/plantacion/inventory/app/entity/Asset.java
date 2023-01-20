package com.plantacion.inventory.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String asset_Id;
    private String asset_Description;
    private String asset_Category;
    private String asset_User;
    private String new_AssetId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AssetComponent component;
}
