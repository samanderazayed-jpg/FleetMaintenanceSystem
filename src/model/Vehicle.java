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
     // دالة أساسية ترجع التكلفة الافتراضية، وسيتم إعادة كتابتها (Overriding) في السيارات الفرعية
public double getServiceCostByType(String serviceType) {
    if (serviceType.equals("Oil Change")) return 50.0;
    if (serviceType.equals("Tire Replacement")) return 200.0;
    if (serviceType.equals("Gearbox Service")) return 500.0;
    return 0.0;
}
    // دالة حساب التكلفة الديناميكية الجديدة المعتمدة على الـ Combo Box والأسعار التلقائية
    public double calculateMaintenanceCost() {
        double total = 0.0;
    if (this.getMaintenanceHistory() != null) {
        for (MaintenanceRecord record : this.getMaintenanceHistory()) {
            // استدعاء دالة السعر المتغيرة بتغير نوع الكائن الحالي
            total += this.getServiceCostByType(record.getServiceType()); 
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