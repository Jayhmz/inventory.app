package com.plantacion.inventory.app.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<AssetComponent> component;
}
