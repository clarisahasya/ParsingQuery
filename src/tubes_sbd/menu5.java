/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sbd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */

public class menu5 {
    String line="";
    public void readFile(){
//yafie
//        try (BufferedReader br1 = new BufferedReader(new FileReader("D:/Kuliah/Semester 4/Sistem Basis Data/tubes_sbd/src/shared_pool.txt")))
//acha
    try (BufferedReader br1 = new BufferedReader(new FileReader("D:/Acha/Documents/TUGAS/TELKOM UNIVERSITY/Sistem Basis Data/TUBES2/tubes_sbd/src/shared_pool.txt")))
        {
            while ((line = br1.readLine()) != null) {
                // use comma as separator
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
