package com.plantacion.inventory.app.repository;

import com.plantacion.inventory.app.model.domain.Component;
import com.plantacion.inventory.app.model.dto.AssetComponentDTO;

public interface ComponentRepository {
    public Component save(Component component);
}
