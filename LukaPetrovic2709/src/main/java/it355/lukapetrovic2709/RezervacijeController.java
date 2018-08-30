/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709;

import it355.lukapetrovic27099.dao.RestoranDao;
import it355.lukapetrovic27099.dao.RezervacijaDao;
import it355.lukapetrovic2709.model.Rezervacija;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class RezervacijeController {
    
    @Autowired
    private RezervacijaDao rezervacijaDao;
    
    @Autowired
    private RestoranDao restoranDao;
    
    @RequestMapping(value="/rezervisanje", method = RequestMethod.GET)
    public String rezervisanje(Model model){
        model.addAttribute("rezervacija", new Rezervacija());
        model.addAttribute("restorani", restoranDao.getAllRestorani());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            model.addAttribute("usernameKorisnika", userDetails.getUsername());
        }
        
        return "rezervisanje";
    }
    
    @RequestMapping(value="/rezervisanje", method = RequestMethod.POST)
    public ModelAndView rezervisanje(@ModelAttribute("rezervacija") Rezervacija rezervacija, ModelAndView model){
        //rezervacija.setIdRezervacije(rezervacijaDao.getBrojRezervacija()+1);
            
        rezervacija = rezervacijaDao.addRezervaciju(rezervacija);
        
        model.addObject("restorani", restoranDao.getAllRestorani());
        model.addObject("successMsg", "Uspesna rezervacija!");
        model.addObject("rezervacija", rezervacija);
        
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            model.addObject("usernameKorisnika", userDetails.getUsername());
        }
        return model;
    }
    
    @RequestMapping(value="/listaRezervacija", method=RequestMethod.GET)
    public ModelAndView listaRezervacija(ModelAndView modelAndView) {
        modelAndView.addObject("rez", rezervacijaDao.getAllRezervacije());
        modelAndView.addObject("rezervacija", new Rezervacija());
        return modelAndView;
    }
    
    @RequestMapping(value = "/deleteRezervaciju/{idRezervacije}", method = RequestMethod.GET)
    public String deleteRezervaciju(@PathVariable("idRezervacije") int idRezervacije, HttpServletRequest request) {
        System.out.println("Fetching & Deleting room with id " + idRezervacije);
        Rezervacija rez = rezervacijaDao.getRezervacijaPoId(idRezervacije);
        if (rez == null) {
            System.out.println("Unable to delete. Room with id " + idRezervacije + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        rezervacijaDao.deleteRezervaciju(rez);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
