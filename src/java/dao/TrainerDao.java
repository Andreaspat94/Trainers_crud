/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Trainer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author George
 */
public class TrainerDao {


    public List<Trainer> getTrainers() {
        System.out.println("ENTERED GET TRAINERS");
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("Trainers_crudPU");
        EntityManager em = emf.createEntityManager();
        
        List<Trainer> trainers = (List<Trainer>) em.createQuery("SELECT t FROM Trainer t").getResultList();
        
        em.close();
        emf.close();
        return trainers;
    }
    
     public boolean updateTrainer(Trainer t) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("Trainers_crudPU");
        EntityManager em = emf.createEntityManager();
        
        Trainer fromDBTrainer = em.find(entities.Trainer.class, t.getId());
        fromDBTrainer.setFname(t.getFname());
        fromDBTrainer.setLname(t.getLname());
        fromDBTrainer.setSubject(t.getSubject());
        em.getTransaction().begin();
        try {
            // transaction
            em.persist(fromDBTrainer);
            em.getTransaction().commit();
            completed = true;
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
        return completed;
    }
     
    public boolean insertTrainer(Trainer t) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("Trainers_crudPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            // transaction
            em.persist(t);
            em.getTransaction().commit();
            completed = true;
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
        return completed;
    }
    
     public boolean deleteTrainer(Trainer t) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("Trainers_crudPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            // transaction
            Trainer trainer = em.find(Trainer.class, t.getId()); 
            em.remove(trainer);
            em.getTransaction().commit();
            completed = true;
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
        return completed;
    }
}
