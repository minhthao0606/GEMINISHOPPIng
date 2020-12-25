/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.BestSellerDao;
import dao.impl.BestSellerImpl;
import java.util.ArrayList;
import model.BestSeller;
import service.BestSellerService;

/**
 *
 * @author gf63
 */
public class BestSellerServiceImpl implements BestSellerService {
    
    BestSellerDao bestSellerDao = new BestSellerImpl();
    
    @Override
    public ArrayList<BestSeller> getBestSeller() {
        return bestSellerDao.getBestSeller();
    }

    @Override
    public ArrayList<BestSeller> getBestBuyer() {
       return bestSellerDao.getBestBuyer();
    }
    
}
