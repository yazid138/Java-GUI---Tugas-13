/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.makanan;

import com.yazid.db.DbService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ma39i
 */
public class MakananService {

    private static Statement statement;
    private ArrayList<Makanan> makananList;

    public ArrayList<Makanan> all() {
        makananList = new ArrayList<>();
        try {
            String query = "SELECT * FROM makanan ";
            ResultSet result = DbService.get(query);
            while (result.next()) {
                makananList.add(new Makanan(
                        result.getInt("id"),
                        result.getString("nama"),
                        result.getString("jenis"),
                        result.getInt("rating"),
                        result.getFloat("jumlah_kalori")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeConnection();
            return makananList;
        }
    }

    public ArrayList<Makanan> where(String where) {
        makananList = new ArrayList<>();
        try {
            String query = "SELECT * FROM makanan WHERE " + where;
            ResultSet result = DbService.get(query);
            while (result.next()) {
                makananList.add(new Makanan(
                        result.getInt("id"),
                        result.getString("nama"),
                        result.getString("jenis"),
                        result.getInt("rating"),
                        result.getFloat("jumlah_kalori")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeConnection();
            return makananList;
        }
    }

    public boolean insert(String nama, String jenis, String rating, String kalori) {
        boolean result = false;
        try {
            Connection conn = DbService.openConnection();
            String query = "INSERT INTO makanan(nama, jenis, rating, jumlah_kalori) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nama);
            statement.setString(2, jenis);
            statement.setString(3, rating);
            statement.setString(4, kalori);
            int created = statement.executeUpdate();
            if (created > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        DbService.closeConnection();
        return result;
    }
}
