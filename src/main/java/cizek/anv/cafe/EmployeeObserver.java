/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class EmployeeObserver implements Observer{

    private String name;
    
    public EmployeeObserver(String name) {
        if (name!=null) {
            this.name=name;
        } else {
            throw new IllegalArgumentException("Employee name cannot be null");
        }
        
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void update(String status) {
        if (status!=null) {
            System.out.println(name + " notified: " + status);
        }
    }
    
}
