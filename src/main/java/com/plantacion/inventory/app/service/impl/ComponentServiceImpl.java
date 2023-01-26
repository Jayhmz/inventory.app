package com.plantacion.inventory.app.service.impl;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.model.domain.Component;
import com.plantacion.inventory.app.model.dto.AssetComponentDTO;
import com.plantacion.inventory.app.repository.AssetRepository;
import com.plantacion.inventory.app.repository.ComponentRepository;
import com.plantacion.inventory.app.service.ComponentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;
    private final AssetRepository assetRepository;

    public ComponentServiceImpl(ComponentRepository componentRepository, AssetRepository assetRepository) {
        this.componentRepository = componentRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    @Transactional
    public Component save(AssetComponentDTO component) {
        Asset parentAsset = assetRepository.findById(component.getAsset_Id());

        if(parentAsset != null){
            Component c = Component.builder()
                    .asset(parentAsset)
                    .component_Name(component.getComponent_Name())
                    .component_Id(component.getComponent_Id())
                    .new_ComponentId(component.getNew_componentId())
                    .component_Serial_No(component.getComponent_Serial_No())
                    .availability_Details(component.getAvailability_Details())
                    .status(component.getStatus())
                    .movement_Details(component.getMovement_Details())
                    .build();

            componentRepository.save(c);
            return c;
        }else{
            throw new IllegalArgumentException("Asset id not found");
        }

    }
}
