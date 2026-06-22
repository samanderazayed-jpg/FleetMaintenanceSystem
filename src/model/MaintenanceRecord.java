/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

import java.time.LocalDate;

public class MaintenanceRecord implements Serializable {
    private String serviceType; // نوع الصيانة (Oil Change, Tire Replacement, Gearbox Service)
    private double cost;        // التكلفة التي ستحدد تلقائياً
    private String date;        // التاريخ

    // الـ Constructor (مشيّد الكائن)
    public MaintenanceRecord(String serviceType, double cost, String date) {
        this.serviceType = serviceType;
        this.cost = cost;
        this.date = date;
    }

    // الـ Getters والـ Setters (مبدأ الكبسولة Encapsulation)
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}