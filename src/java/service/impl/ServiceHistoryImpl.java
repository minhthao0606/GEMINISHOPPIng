/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.HistoryDao;
import dao.impl.HistoryDaoImpl;
import java.util.ArrayList;
import model.History;

/**
 *
 * @author gf63
 */
public class ServiceHistoryImpl implements service.ServiceHistory{
    HistoryDao historyDao = new HistoryDaoImpl();
    
    @Override
    public ArrayList<History> getByUser(int uid) {
        return historyDao.getByUser(uid);
    }
    
}
