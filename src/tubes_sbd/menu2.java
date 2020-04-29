/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sbd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class menu2 {
    //file yafie
//  String salon = "D:/Kuliah/Semester 4/Sistem Basis Data/tubes_sbd/src/file/salon.csv";
//  String treatment ="D:/Kuliah/Semester 4/Sistem Basis Data/tubes_sbd/src/file/treatment.csv";
//  String memiliki ="D:/Kuliah/Semester 4/Sistem Basis Data/tubes_sbd/src/file/memiliki.csv";
//  String prop = "D:/Kuliah/Semester 4/Sistem Basis Data/tubes_sbd/src/file/prop.csv";
    
    //file acha
    String salon = "D:/Acha/Documents/TUGAS/TELKOM UNIVERSITY/Sistem Basis Data/TUBES2/tubes_sbd/src/file/salon.csv";
    String treatment ="D:/Acha/Documents/TUGAS/TELKOM UNIVERSITY/Sistem Basis Data/TUBES2/tubes_sbd/src/file/treatment.csv";
    String memiliki ="D:/Acha/Documents/TUGAS/TELKOM UNIVERSITY/Sistem Basis Data/TUBES2/tubes_sbd/src/file/memiliki.csv";
    String prop = "D:/Acha/Documents/TUGAS/TELKOM UNIVERSITY/Sistem Basis Data/TUBES2/tubes_sbd/src/file/prop.csv";
    
    String line = "";
    String csvSplitBy = ",";
    String[] tablesSalon = new String[100];
    String[] tablesTreatment = new String[100];
    String[] tablesMemiliki = new String[100];
    String[] tablesProp = new String[100];
    
    menu1 menu1 = new menu1();
    
    public void block() {
        //masukkan csv salon ke array tablesSalon
        try (BufferedReader br = new BufferedReader(new FileReader(salon))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                tablesSalon = line.split(csvSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //selesai
        
        //masukkan csv treatment ke array tablesTreatment
        try (BufferedReader br1 = new BufferedReader(new FileReader(treatment))) {
            while ((line = br1.readLine()) != null) {
                // use comma as separator
                tablesTreatment = line.split(csvSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //selesai
        
        //masukkan csv memiliki ke array tablesMemiliki
        try (BufferedReader br1 = new BufferedReader(new FileReader(memiliki))) {
            while ((line = br1.readLine()) != null) {
                // use comma as separator
                tablesMemiliki = line.split(csvSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //masukkan csv prop ke array tablesProp
        try (BufferedReader br1 = new BufferedReader(new FileReader(prop))) {
            while ((line = br1.readLine()) != null) {
                // use comma as separator
                tablesProp = line.split(csvSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //selesai     
        
        int P = Integer.valueOf(tablesProp[0]);
        int B = Integer.valueOf(tablesProp[1]);
        int Rs = Integer.valueOf(tablesSalon[6]);
        int ns = Integer.valueOf(tablesSalon[7]);
        int vs = Integer.valueOf(tablesSalon[8]);
        int Rm = Integer.valueOf(tablesMemiliki[3]);
        int nm = Integer.valueOf(tablesMemiliki[4]);
        int vm = Integer.valueOf(tablesMemiliki[5]);
        int Rt = Integer.valueOf(tablesTreatment[5]);
        int nt = Integer.valueOf(tablesTreatment[6]);
        int vt = Integer.valueOf(tablesTreatment[7]);
        
        String names = tablesSalon[0];       
        String namem = tablesMemiliki[0];
        String namet = tablesTreatment[0];
        
        showSalon(names, B, P, Rs, ns, vs);
        showMemiliki(namem, B, P, Rm, nm, vm);
        showTreatment(namet, B, P, Rt, nt, vt); 
    }
    
    public void showSalon(String name, int B, int P, int R, int n, int v) {
        double x = countBlockData(B,R,n);
        double y = countBlockIndex(B,P,n,v);
        System.out.println("Tabel Data "+name+" : "+x);
        System.out.println("Index "+name+" : "+y);
    }
    
    public void showMemiliki(String name, int B, int P, int R, int n, int v) {
        double x = countBlockData(B,R,n);
        double y = countBlockIndex(B,P,n,v);
        System.out.println("Tabel Data "+name+" : "+x);
        System.out.println("Index "+name+" : "+y);
    }
    
    public void showTreatment(String name, int B, int P, int R, int n, int v) {
        double x = countBlockData(B,R,n);
        double y = countBlockIndex(B,P,n,v);
        System.out.println("Tabel Data "+name+" : "+x);
        System.out.println("Index "+name+" : "+y);
    }
    
    public double countBlockData(int B, int R, int n){
        double x = menu1.countBfr(B, R);
        double y = n/x;
        double hasil = Math.ceil(y);
        return hasil;
    }
    
    public double countBlockIndex(int B, int P, int n, int v) {
        double x = menu1.countFanoutRatio(B, P, v);
        double y = n/x;
        double hasil = Math.ceil(y);
        return hasil;
    }
}
