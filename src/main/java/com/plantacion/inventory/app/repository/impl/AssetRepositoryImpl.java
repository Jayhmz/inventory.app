package com.plantacion.inventory.app.repository.impl;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.repository.AssetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AssetRepositoryImpl implements AssetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Asset save(Asset asset) {
        entityManager.persist(asset);
        return asset;
    }
}
