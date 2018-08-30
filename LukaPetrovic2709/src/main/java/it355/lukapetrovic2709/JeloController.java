/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709;

import it355.lukapetrovic27099.dao.JeloDao;
import it355.lukapetrovic2709.model.Jelo;
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
public class JeloController {
    
    @Autowired
    private JeloDao jeloDao;
    
    @RequestMapping(value = {"/dodajJelo",}, method = RequestMethod.GET)
    public String addJelo(Model model) {
        model.addAttribute("jelo", new Jelo());
        return "dodajJelo";
    }

    @RequestMapping(value = "/dodajJelo", method = RequestMethod.POST)
    public ModelAndView addJelo(@ModelAttribute("jelo") Jelo jelo, ModelAndView model){

            jelo = jeloDao.addJelo(jelo);
            model.addObject("successMsg", "Uspesno ste dodali jelo!");

        model.addObject("jelo", jelo);

        model.setViewName("redirect:jelovnik");
        return model;
    }
    
    @RequestMapping(value="/jelovnik", method=RequestMethod.GET)
    public String jelovnik(Model model) {
        List<Jelo> jela = jeloDao.getAllJela();
        model.addAttribute("jela", jela);
        return "jelovnik";
    }
    
    @RequestMapping(value = "/deleteJelo/{idJela}", method = RequestMethod.GET)
    public String deleteJelo(@PathVariable("idJela") int idJela, HttpServletRequest request) {
        System.out.println("Fetching & Deleting room with id " + idJela);
        Jelo jelo = jeloDao.getJeloById(idJela);
        if (jelo == null) {
            System.out.println("Unable to delete. Room with id " + idJela + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        jeloDao.deleteJelo(jelo);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
