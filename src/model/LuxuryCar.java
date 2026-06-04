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

    // تطبيق مفهوم التعددية الشكلية (Method Overriding)
    @Override
    public double calculateEstimatedMaintenanceCost(double baseCost) {
        // السيارات الفاخرة تكلفة صيانتها أعلى بنسبة 50% من التكلفة الأساسية
        return baseCost * 1.5;
    }
}
