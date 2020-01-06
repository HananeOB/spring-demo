package com.emse.spring.faircorp.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class RoomDaoImpl implements RoomDaoCustom {

        @PersistenceContext
        private EntityManager em;

        @Override
        public List<String> findRoomByName(String name) {
            String jpql = "select r.name from Room as r where r.name = :value";
            return em.createQuery(jpql, String.class)
                    .setParameter("value", name)
                    .getResultList();
        }
        @Override
        public List<Light> findRoomLight(long id){
            String jpql = "select l from Light l where l.room.id = :id";
            return em.createQuery(jpql, Light.class)
                    .setParameter("id", id )
                    .getResultList();
        }


        @Override
        public List<Long> findAllRoomId(){
            String jpql = "select r.id from Room r";
            return em.createQuery(jpql, Long.class)
                    .getResultList();
        }


    }

