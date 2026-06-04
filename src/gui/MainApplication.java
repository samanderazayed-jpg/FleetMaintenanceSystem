/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import database.DatabaseService;
import model.FleetManager;
import model.LuxuryCar;
import model.Truck;

public class MainApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Initializing Fleet Maintenance Management System ===");
        
        // تشغيل واجهة المستخدم الرسومية مباشرة
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dashboard dashboard = new Dashboard();
                dashboard.setLocationRelativeTo(null); // عرض الشاشة في المنتصف
                dashboard.setVisible(true); // إظهار الشاشة
            }
        });
        
        System.out.println("=== System GUI window opened ===");
    }
}