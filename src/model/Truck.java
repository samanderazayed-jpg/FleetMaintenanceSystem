/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// الشاحنة ترث أيضاً من كلاس المركبة العام
public class Truck extends Vehicle {
    
    public Truck(String vin, String model, int year, double currentOdometer) {
        super(vin, model, year, currentOdometer);
    }
      @Override
public double getServiceCostByType(String serviceType) {
    if (serviceType.equals("Oil Change")) return 250.0;       // كمية زيت أكبر للشاحنة
    if (serviceType.equals("Tire Replacement")) return 600.0; // إطارات شاحنة ضخمة
    if (serviceType.equals("Gearbox Service")) return 1200.0;
    return 0.0;
}
    // إعادة كتابة الدالة لتناسب الشاحنات (Polymorphism)
    
    @Override
public double calculateMaintenanceCost() {
    // تكلفة الشاحنة = التكلفة الأساسية (100) + 150 دولار إضافية للشاحنات
    return super.calculateMaintenanceCost() ; 
}
}
