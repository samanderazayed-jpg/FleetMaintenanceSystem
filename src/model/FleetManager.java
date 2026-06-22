/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class FleetManager {
    // تطبيق مفهوم التكوين (Composition): الأسطول يتكون من قائمة سيارات
    private ArrayList<Vehicle> fleetList;

    // الباني (Constructor) لتجهيز القائمة فور إنشاء مدير الأسطول
    public FleetManager() {
        this.fleetList = new ArrayList<>();
    }

    // دالة لإضافة سيارة جديدة إلى الأسطول (تخدم الـ Use Case الأول)
    public void addVehicle(Vehicle vehicle) {
        fleetList.add(vehicle);
    }

    // دالة للحصول على القائمة الكاملة للسيارات لعرضها في الواجهة لاحقاً
    public ArrayList<Vehicle> getFleetList() {
        return fleetList;
    }

   // دالة حسابية متقدمة: تحسب إجمالي مصاريف الصيانة الفعلية للأسطول بالكامل
    // نستخدم فيها الـ Polymorphism لأن البرنامج يمر على كل مركبة ويستدعي حسبتها الخاصة
    public double calculateTotalEstimatedFleetCost() {
        double totalCost = 0.0;
        
        // Loop ليمر على كل السيارات في الأسطول ويجمع تكاليفها ديناميكياً
        for (Vehicle v : fleetList) {
            // استدعاء الدالة الديناميكية الجديدة التي لا تأخذ معاملات (No parameters)
            totalCost += v.calculateMaintenanceCost();
        }
        
        return totalCost;
    }
}
