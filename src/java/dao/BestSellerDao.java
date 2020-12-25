/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.BestSeller;

/**
 *
 * @author gf63
 */
public interface BestSellerDao {
    ArrayList< BestSeller> getBestSeller();
    
    ArrayList< BestSeller> getBestBuyer();
}
