/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// تطبيق مفهوم الوراثة (Inheritance) باستخدام كلمة extends
public class LuxuryCar extends Vehicle {
    
    // الباني (Constructor): يستقبل البيانات ويمررها للأب باستخدام super
    public LuxuryCar(String vin, String model, int year, double currentOdometer) {
        super(vin, model, year, currentOdometer);
    }
      @Override
public double getServiceCostByType(String serviceType) {
    if (serviceType.equals("Oil Change")) return 120.0;       // زيت سيارة فاخرة أغلى
    if (serviceType.equals("Tire Replacement")) return 400.0; // إطارات سيارة فاخرة
    if (serviceType.equals("Gearbox Service")) return 800.0;
    return 0.0;
}
    // تطبيق مفهوم التعددية الشكلية (Method Overriding)
   
    @Override
public double calculateMaintenanceCost() {
    // تكلفة السيارة الفارهة = التكلفة الأساسية (100) + 300 دولار إضافية للفخامة
    return super.calculateMaintenanceCost() ;
}
}
