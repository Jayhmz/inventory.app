package com.plantacion.inventory.app.service.impl;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.repository.AssetRepository;
import com.plantacion.inventory.app.service.AssetService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository repository;

    public AssetServiceImpl(AssetRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Asset save(Asset asset) {
        return repository.save(asset);
    }
}
