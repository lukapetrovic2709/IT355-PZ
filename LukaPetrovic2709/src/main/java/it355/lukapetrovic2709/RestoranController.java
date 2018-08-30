/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709;

import it355.lukapetrovic27099.dao.RestoranDao;
import it355.lukapetrovic2709.model.Restoran;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 1uksha
 */
@Controller
public class RestoranController {
    
    @Autowired
    private RestoranDao restoranDao;
    
    @RequestMapping(value = {"/dodajRestoran",}, method = RequestMethod.GET)
    public String addRestoran(Model model) {
        model.addAttribute("restoran", new Restoran());
        return "dodajRestoran";
    }

    @RequestMapping(value = "/dodajRestoran", method = RequestMethod.POST)
    public ModelAndView addRestoran(@ModelAttribute("restoran") Restoran restoran, ModelAndView model){
        
            restoran = restoranDao.addRestoran(restoran);
            model.addObject("successMsg", "Uspesno ste dodali restoran!");

        model.addObject("restoran", restoran);

        model.setViewName("redirect:listaRestorana");
        return model;
    }
    
    @RequestMapping(value="/listaRestorana", method=RequestMethod.GET)
    public String listaRestorana(Model model) {
        List<Restoran> restorani = restoranDao.getAllRestorani();
        model.addAttribute("restorani", restorani);
        return "listaRestorana";
    }
    
    @RequestMapping(value = "/deleteRestoran/{idRestorana}", method = RequestMethod.GET)
    public String deleteRestoran(@PathVariable("idRestorana") int idRestorana, HttpServletRequest request) {
        
        Restoran restoran = restoranDao.getRestoranPoId(idRestorana);
        if (restoran == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        restoranDao.deleteRestoran(restoran);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
