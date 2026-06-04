/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

public class MaintenanceRecord {
    // تطبيق التغليف لجعل المتغيرات خاصة
    private String serviceType; // مثل: تغيير زيت، فحص فرامل
    private LocalDate serviceDate; // تاريخ الصيانة
    private double cost; // التكلفة المالية

    // الباني لإنشاء السجل
    public MaintenanceRecord(String serviceType, LocalDate serviceDate, double cost) {
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.cost = cost;
    }

    // Getters للوصول إلى البيانات بشكل آمن
    public String getServiceType() { return serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public double getCost() { return cost; }
}
