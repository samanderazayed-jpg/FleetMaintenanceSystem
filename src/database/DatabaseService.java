/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.FleetManager;
import model.LuxuryCar;
import model.Truck;
import model.Vehicle;

public class DatabaseService {
    // اسم ملف قاعدة البيانات النصي الذي سيتم حفظ السيارات داخله
    // بدلاً من الاسم المجرد، نحدد مساراً ثابتاً في النظام ليحفظ فيه دائماً
     private static final String FILE_NAME = System.getProperty("user.home") + File.separator + "fleet_database.txt";  

    // دالة لحفظ بيانات الأسطول بالكامل داخل الملف (تحاكي عملية الحفظ في الداتابيز)
    public static void saveFleetData(FleetManager manager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Vehicle v : manager.getFleetList()) {
                // تحديد نوع السيارة لكي نعرف كيف نخزنها
                String type = (v instanceof LuxuryCar) ? "Luxury" : "Truck";
                
                // كتابة البيانات وفصلها بعلامة الفاصلة (,) لتسهيل قراءتها لاحقاً
                writer.write(type + "," + v.getVin() + "," + v.getModel() + "," + v.getYear() + "," + v.getCurrentOdometer());
                writer.newLine();
            }
            System.out.println("Database Status: Fleet data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Database Error: Could not save data! " + e.getMessage());
        }
    }

    // دالة لاسترجاع وقراءة البيانات من الملف وتحويلها إلى كائنات جافا عند تشغيل البرنامج
    public static void loadFleetData(FleetManager manager) {
        File file = new File(FILE_NAME);
        // إذا كان الملف غير موجود (أول مرة يشغل البرنامج)، لا تفعل شيئاً
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // تقسيم السطر بناءً على الفاصلة
                String[] data = line.split(",");
                if (data.length == 5) {
                    String type = data[0];
                    String vin = data[1];
                    String model = data[2];
                    int year = Integer.parseInt(data[3]);
                    double odometer = Double.parseDouble(data[4]);

                    // إعادة بناء الكائنات وضخها في الـ FleetManager حسب نوعها
                    if (type.equals("Luxury")) {
                        manager.addVehicle(new LuxuryCar(vin, model, year, odometer));
                    } else if (type.equals("Truck")) {
                        manager.addVehicle(new Truck(vin, model, year, odometer));
                    }
                }
            }
            System.out.println("Database Status: Fleet data loaded successfully. Total loaded: " + manager.getFleetList().size());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Database Error: Could not load data! " + e.getMessage());
        }
    }
}
