/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.BestSellerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.DBContext;
import model.BestSeller;

/**
 *
 * @author gf63
 */
public class BestSellerImpl extends DBContext implements BestSellerDao{

    @Override
    public ArrayList<BestSeller> getBestSeller() {
        ArrayList< BestSeller> list = new ArrayList();
        String sql = "select top 5 product.name, sum(CartItem.quantity * CartItem.unitPrice) as total , cartItem.pro_id from [user]\n"
                + "join Cart on cart.u_id = [user].id\n"
                + "join CartItem on Cart.id = CartItem.cat_id\n"
                + "join Product on Product.id = CartItem.pro_id\n"
                + "group by product.name, cartItem.pro_id\n"
                + "order by total desc";
        Connection conn = super.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BestSeller(rs.getString(1), rs.getInt(2)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
        

    @Override
    public ArrayList<BestSeller> getBestBuyer() {
       ArrayList< BestSeller> list = new ArrayList();
        String sql = "select sum(CartItem.quantity) as total , [user].username from [user]\n"
                + "join Cart on cart.u_id = [user].id\n"
                + "join CartItem on Cart.id = CartItem.cat_id\n"
                + "join Product on Product.id = CartItem.pro_id\n"
                + "group by [user].username\n"
                + "order by total desc";
        Connection conn = super.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BestSeller(rs.getString(2), rs.getInt(1)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
}
