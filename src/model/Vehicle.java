/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// كلاس أب مجرد يجمع صفات كل السيارات (تطبيق مفهوم التجريد)
public abstract class Vehicle {
    // متغيرات خاصة محمية (تطبيق مفهوم التغليف)
    private String vin;
    private String model;
    private int year;
    private double currentOdometer;

    // الباني لإنشاء السيارة وتخزين بياناتها أول مرة
    public Vehicle(String vin, String model, int year, double currentOdometer) {
        this.vin = vin;
        this.model = model;
        this.year = year;
        this.currentOdometer = currentOdometer;
    }

    // دالة مجردة لحساب تكلفة الصيانة تختلف من سيارة لأخرى (Polymorphism)
    public abstract double calculateEstimatedMaintenanceCost(double baseCost);

    // دالة للوصول لقراءة العداد الحالية
    public double getCurrentOdometer() {
        return currentOdometer;
    }

    // دالة تحديث العداد مع حماية البيانات من الإدخال الخاطئ (Exception Handling)
   public void setCurrentOdometer(double newOdometer) throws IllegalArgumentException {
    if (newOdometer < this.currentOdometer) {
        throw new IllegalArgumentException("Error: New odometer reading cannot be less than the current reading!");
    }
    this.currentOdometer = newOdometer;
}

    // الـ Getters البسيطة لباقي المتغيرات
    public String getVin() { return vin; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
