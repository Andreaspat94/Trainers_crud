/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TrainerDao;
import entities.Trainer;
import java.util.List;
/**
 *
 * @author George
 */
public class TrainerService {
    TrainerDao tdao= new TrainerDao();
    
    public List <Trainer> getTrainers() {
        System.out.println("ENTERED TRAINER SERVICE!!!!!!");
        return tdao.getTrainers();
    }
    
    public boolean insertTrainer(Trainer t) {
        return tdao.insertTrainer(t);
    }
    public boolean updateTrainer(Trainer t) {
        return tdao.updateTrainer(t);
    }
    public boolean deleteTrainer(Trainer t) {
        return tdao.deleteTrainer(t);
    }
}
