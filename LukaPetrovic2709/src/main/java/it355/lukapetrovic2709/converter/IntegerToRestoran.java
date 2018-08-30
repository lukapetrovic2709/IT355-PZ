/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.converter;

import it355.lukapetrovic27099.dao.RestoranDao;
import it355.lukapetrovic2709.model.Restoran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author 1uksha
 */
@Component
public class IntegerToRestoran implements Converter<String , Restoran>{
    
    @Autowired
    RestoranDao restoranDao;

    @Override
    public Restoran convert(String s) {
        if(s.isEmpty()){
            return null;
        }
        Integer vrednost = Integer.valueOf(s);
        System.out.println("Konvertujem u kategoriju");
        Restoran rest = restoranDao.getRestoranPoId(vrednost);
        return rest;
    }
}
