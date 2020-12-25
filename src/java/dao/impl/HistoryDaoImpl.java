/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.HistoryDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.DBContext;
import model.Category;
import model.History;
import model.Product;

/**
 *
 * @author gf63
 */
public class HistoryDaoImpl extends DBContext implements HistoryDao{

    @Override
    public ArrayList<History> getByUser(int uid) {
        ArrayList< History> list = new ArrayList();
        String sql = "select buyDate, product.name, product.image,  unitPrice, CartItem.quantity , unitPrice*CartItem.quantity as amount  from [user]\n"
                + "join Cart on cart.u_id = [user].id\n"
                + "join CartItem on Cart.id = CartItem.cat_id\n"
                + "join Product on Product.id = CartItem.pro_id\n"
                + "where [user].id = ?";
        Connection con = super.getConnection();
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                list.add(new History(rs.getDate(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));           
            }            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        return list;
    }
    
}
