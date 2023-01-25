package com.plantacion.inventory.app.repository;

import com.plantacion.inventory.app.model.domain.Asset;

public interface AssetRepository {
    public Asset save(Asset asset);
    public Asset findById(String asset_id);
}
