package com.plantacion.inventory.app.repository.impl;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.repository.AssetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetRepositoryImpl implements AssetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Asset save(Asset asset) {
        entityManager.persist(asset);
        return asset;
    }

    @Override
    public Asset findById(String new_asset_id) {
        String query = "select a from Asset a where a.new_AssetId = :new_asset_id";
        TypedQuery<Asset> q = entityManager.createQuery(query, Asset.class);
        q.setParameter("new_asset_id", new_asset_id);
        return q.getSingleResult();
    }

    @Override
    public Asset findBySerialNo(String serial_no) {
//        String query =  "select a.asset_Serial_No from Asset a where a.asset_Serial_No = :serial_nom";
        TypedQuery<Asset> q = entityManager.createQuery("SELECT e FROM Asset e WHERE e.asset_Serial_No = :serial_nom", Asset.class);
        q.setParameter("serial_nom", serial_no);

        try {
            Asset singleResult = q.getSingleResult();
            System.out.println("inside try and catch phase 1 ");

            System.out.println("actually returned a result that is valid and not empty string" + singleResult.getAsset_Serial_No());
            return singleResult;

        }catch (Exception e){
            System.out.println("this will work repo" +e);
            return null;
        }
    }

    @Override
    public List<Asset> getAllAssets() {
        String query = "select a from Asset a";
        TypedQuery<Asset> assets = entityManager.createQuery(query, Asset.class);
        return assets.getResultList();
    }
}
