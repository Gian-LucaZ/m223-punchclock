package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;
import ch.zli.m223.validator.Validate;
import ch.zli.m223.exceptions.EntryNotFoundException;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    private Validate val = new Validate();

    @Transactional
    public Entry createEntry(Entry entry) {
        val.entry(entry).throwIfInvalid();
        entityManager.persist(entry);
        return entry;
    }

    @Transactional
    public Entry deleteEntry(Long id) throws Exception{
        for (Entry e : findAll()) {
            if (e.getId() == id) {
                entityManager.remove(e);
                
                return e;
            }
        }

        throw new EntryNotFoundException(id);
    }

    @Transactional
    public Entry alterEntry(Long id, Entry e){
        val.entry(e).throwIfInvalid();
        return entityManager.merge(e);
    }

    public Entry findById(Long id){
        return entityManager.find(Entry.class, id);
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }
}
