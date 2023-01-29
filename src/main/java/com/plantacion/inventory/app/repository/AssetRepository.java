package com.plantacion.inventory.app.repository;

import com.plantacion.inventory.app.model.domain.Asset;

import java.util.List;

public interface AssetRepository {
    public Asset save(Asset asset);
    public Asset findById(String asset_id);

    public Asset findBySerialNo(String serial_no);

    public List<Asset> getAllAssets();
}
