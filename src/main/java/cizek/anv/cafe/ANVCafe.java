/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class ANVCafe {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CafeConfig config = CafeConfig.getInstance("test");
        System.out.println(CafeConfig.getInstance("this shouldnt work").getCafeName());
        System.out.println(config.getCafeName());
    }
}
