package model;

import java.io.Serializable;
import java.util.ArrayList;

// كلاس أب مجرد يجمع صفات كل السيارات (تطبيق مفهوم التجريد والـ Serializable لحفظ البيانات)
public abstract class Vehicle implements Serializable {
    // متغيرات خاصة محمية (تطبيق مفهوم التغليف Encapsulation)
    private String vin;
    private String model;
    private int year;
    private double currentOdometer;
    
    // الحل هنا: أضفنا قائمة لتخزين سجلات صيانة المركبة
    private ArrayList<MaintenanceRecord> maintenanceHistory; 

    // الباني لإنشاء السيارة وتخزين بياناتها أول مرة
    public Vehicle(String vin, String model, int year, double currentOdometer) {
        this.vin = vin;
        this.model = model;
        this.year = year;
        this.currentOdometer = currentOdometer;
        this.maintenanceHistory = new ArrayList<>(); // تهيئة القائمة لمنع الـ NullPointerException
    }

    // دالة حساب التكلفة الديناميكية الجديدة المعتمدة على الـ Combo Box والأسعار التلقائية
    public double calculateMaintenanceCost() {
        double total = 0.0;
        if (this.maintenanceHistory != null) {
            for (MaintenanceRecord record : this.maintenanceHistory) {
                total += record.getCost(); // جمع تكلفة كل خدمة مضافة للسيارة (50 أو 200 أو 500)
            }
        }
        return total;
    }

    // دالة للوصول لقائمة تاريخ الصيانة (Getter) يحتاجها زر الـ Dashboard
    public ArrayList<MaintenanceRecord> getMaintenanceHistory() {
        if (this.maintenanceHistory == null) {
            this.maintenanceHistory = new ArrayList<>();
        }
        return this.maintenanceHistory;
    }

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
    
    // دالة تعديل الموديل (التي حلت خطأ زر التعديل سابقاً)
    public void setModel(String model) {
        this.model = model;
    }

    // الـ Getters البسيطة لباقي المتغيرات
    public String getVin() { return vin; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}