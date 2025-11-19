/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class OrderCommand implements Command {
    private OrderSubject subject;
    private String order;

    public OrderCommand(OrderSubject subject, String order) {
        this.subject=subject;
        this.order=order;
    }

    @Override
    public void execute() {
        subject.notifyAll(order);
    }
    
}
