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
public class menu3 {
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
    
    public void record() {
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
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Cari Record ke- : ");
        int x = sc.nextInt();
        System.out.println("Nama Tabel : ");
        String name = sc.next();
        
        if ((x <= ns) && (tablesSalon[0].equals(name))) {
            double i = countWithIndex(B, P, vs, x);
            double j = countWithoutIndex(B, Rs, x);
            System.out.println("Menggunakan indeks, jumlah blok yang diakses : "+i+" blok");
            System.out.println("Tanpa indeks, jumlah blok yang diakses : "+j+" blok");            
        } else if((x <= nm) && (tablesMemiliki[0].equals(name))) {
            double i = countWithIndex(B, P, vm, x);
            double j = countWithoutIndex(B, Rm, x);
            System.out.println("Menggunakan indeks, jumlah blok yang diakses : "+i+" blok");
            System.out.println("Tanpa indeks, jumlah blok yang diakses : "+j+" blok");
        } else if ((x <= nt) && tablesTreatment[0].equals(name)) {
            double i = countWithIndex(B, P, vt, x);
            double j = countWithoutIndex(B, Rt, x);
            System.out.println("Menggunakan indeks, jumlah blok yang diakses : "+i+" blok");
            System.out.println("Tanpa indeks, jumlah blok yang diakses : "+j+" blok");
        } else if ((x>ns) || (x>nm) || (x>nt)){
            System.out.println("Rekord yang diinputkan melebihi batas");
        }         
        else {
            System.out.println("Tabel yang diinputkan tidak ada atau salah");
        }
    }
    
    //rekord ke berapa / fanoutratio
    public double countWithIndex(int B, int P, int v, int x){
        double fr = menu1.countFanoutRatio(B, P, v);
        double a = x/fr;
        double hasil = Math.ceil(a);
        return hasil;
    }
    
    //rekord ke berapa / bfr
    public double countWithoutIndex(int B, int R, int x){
        double bfr = menu1.countBfr(B, R);
        double a = x/bfr;
        double hasil = Math.ceil(a);
        return hasil;
    }
}
