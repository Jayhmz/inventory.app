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

        if (asset.getAsset_Serial_No() != null &&
                !asset.getAsset_Serial_No().equals("")) {
            Asset bySerialNo = assetRepository.findBySerialNo(asset.getAsset_Serial_No());
            //check if that value exist in db, if it does, bounce it back
            if (bySerialNo == null){
                System.out.println("------ inside the bySerialNo block where there is an existing serial no. -------");
                asset.setAsset_Serial_No(asset.getAsset_Serial_No());
            }
            else{
                throw new IllegalArgumentException("Asset serial number already exist");
            }
        }else if(asset.getAsset_Serial_No().equals("")){
            System.out.println("------ inside the bySerialNo block where there is nno serial no. in field attribute. -------");
            asset.setAsset_Serial_No(asset.getAsset_Serial_No());
        }

        Component c = new Component();
        c.setAsset(a);
        c.setNew_ComponentId(asset.getComponent().getNew_componentId());
        c.setComponent_Id(asset.getComponent().getComponent_Id());
        c.setComponent_Name(asset.getComponent().getComponent_Name());
        c.setComponent_Serial_No(asset.getComponent().getComponent_Serial_No());
        c.setStatus(asset.getComponent().getStatus());
        c.setMovement_Details(asset.getComponent().getMovement_Details());
        c.setAvailability_Details(asset.getComponent().getAvailability_Details());

        a.setComponent(c);
        assetRepository.save(a);
        return a;
    }

    @Override
    @Transactional
    public List<Asset> getAllAssets() {
        return assetRepository.getAllAssets();
    }


}
