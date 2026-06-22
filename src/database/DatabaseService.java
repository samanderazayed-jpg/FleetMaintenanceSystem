/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.FleetManager;
import model.Vehicle;

public class DatabaseService {
    private static final String FILE_PATH = "fleet_data.dat";

    // دالة لحفظ بيانات الأسطول بالكامل داخل الملف
    public static void saveFleetData(FleetManager manager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(manager.getFleetList()); // حفظ القائمة كاملة بجميع محتوياتها
        } catch (IOException e) {
            System.err.println("Error saving fleet data: " + e.getMessage());
        }
    }

    // دالة لاسترجاع وقراءة البيانات من الملف وتحويلها إلى كائنات جافا عند تشغيل البرنامج
    @SuppressWarnings("unchecked")
    public static void loadFleetData(FleetManager manager) {
        File file = new File(FILE_PATH);
        if (!file.exists()) return; // إذا كان أول تشغيل للملف

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<Vehicle> list = (ArrayList<Vehicle>) ois.readObject();
            manager.setFleetList(list); // استرجاع القائمة كاملة بالسيارات وصياناتها
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading fleet data: " + e.getMessage());
        }
    }
}
