/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class CafeConfig {
    private static volatile CafeConfig instance;
    private String CafeName;
    
    private CafeConfig(String name) {
        this.CafeName=name;
    }
    
    public static CafeConfig getInstance(String name) {
        CafeConfig result = instance;
        if (result!=null) {
            return result;
        }
        synchronized(CafeConfig.class) {
            if (instance==null) {
                instance=new CafeConfig(name);
            }
            return instance;
        }
    }
    
    public String getCafeName() {
        return CafeName;
    }
    
    //test-only method
    public static void resetForTests() {
        instance = null;
    }
}
