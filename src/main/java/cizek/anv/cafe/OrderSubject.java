/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class OrderSubject {
    private List<Observer> subjects;

    public OrderSubject() {
        this.subjects = new ArrayList<Observer>();
    }
    
    public void addObserver(Observer o) {
        subjects.add(o);
    }
    
    public void removeObserver(Observer o) {
        subjects.remove(o);
    }
    
    public List<Observer> getSubjects() {
        return subjects;
    }
    
    public void notifyAll(String msg) {
        for (Observer o : subjects) {
            o.update(msg);
        }
    }
}
