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

    // إعادة كتابة الدالة لتناسب الشاحنات (Polymorphism)
    @Override
    public double calculateEstimatedMaintenanceCost(double baseCost) {
        // الشاحنات تكلفة صيانتها ضعف التكلفة العادية نظراً لحجمها وجهدها
        return baseCost * 2.0;
    }
}
