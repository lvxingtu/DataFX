package org.datafx.crud.jpa;

import org.datafx.util.EntityWithId;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaGetAllCall<S extends EntityWithId<T>, T> extends JpaCall<Void, List<S>> {

    private Class<S> entityClass;

    public JpaGetAllCall(EntityManager manager, Class<S> entityClass) {
        super(manager);
        this.entityClass = entityClass;
    }

    @Override
    public List<S> call(Void dummy) throws Exception {
        System.out.println("Select a from " + entityClass.getSimpleName() + " a");
        return getManager()
                .createQuery("Select a from " + entityClass.getSimpleName() + " a", entityClass)
                .getResultList();
    }
}
