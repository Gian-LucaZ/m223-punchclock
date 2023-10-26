package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class GenericService {

    @Inject
    private EntityManager entityManager;
    
    @Transactional
    public <T> T create(T item){
        entityManager.persist(item);
        return item;
    }

    @Transactional
    public <T> T delete(Long id, Class<T> targetClass){
        var entity = entityManager.find(targetClass, id);
        entityManager.remove(entity);
        return entity;
    }

    @Transactional
    public <T> T alter(T item){
        entityManager.merge(item);
        return item;
    }
    
    @Transactional
    public <T> List<T> index(Class<T> targetClass){
        var query = entityManager.createQuery("FROM " + targetClass.getName(), targetClass);
        return query.getResultList();
    }
}
