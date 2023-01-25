package com.plantacion.inventory.app.service;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.model.dto.AssetDTO;

public interface AssetService {
    public Asset save(AssetDTO asset);
}
