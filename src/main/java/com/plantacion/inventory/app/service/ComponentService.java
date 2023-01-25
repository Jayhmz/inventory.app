package com.plantacion.inventory.app.service;

import com.plantacion.inventory.app.model.domain.Component;
import com.plantacion.inventory.app.model.dto.AssetComponentDTO;

public interface ComponentService {
    public Component save(AssetComponentDTO component);
}
