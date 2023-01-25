package com.plantacion.inventory.app.service.impl;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.model.domain.Component;
import com.plantacion.inventory.app.model.dto.AssetDTO;
import com.plantacion.inventory.app.repository.AssetRepository;
import com.plantacion.inventory.app.repository.ComponentRepository;
import com.plantacion.inventory.app.service.AssetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final ComponentRepository componentRepository;

    public AssetServiceImpl(AssetRepository assetRepository, ComponentRepository componentRepository) {
        this.assetRepository = assetRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    @Transactional
    public Asset save(AssetDTO asset) {
        Asset a = new Asset();
        BeanUtils.copyProperties(asset, a);
        assetRepository.save(a);
        return a;
    }
}
