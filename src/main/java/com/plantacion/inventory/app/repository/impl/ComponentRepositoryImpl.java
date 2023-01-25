package com.plantacion.inventory.app.repository.impl;

import com.plantacion.inventory.app.model.domain.Component;
import com.plantacion.inventory.app.model.dto.AssetComponentDTO;
import com.plantacion.inventory.app.repository.ComponentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentRepositoryImpl implements ComponentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Component save(Component component) {
        entityManager.persist(component);
        return component;
    }
}
