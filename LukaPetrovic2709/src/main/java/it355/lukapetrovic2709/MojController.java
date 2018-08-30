/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709;


import it355.lukapetrovic27099.dao.KorisnikDao;
import it355.lukapetrovic2709.model.Korisnik;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 1uksha
 */
@Controller
public class MojController {
    
    /*@Autowired
    private RezervacijaDao rezervacijaDao;*/
    
    /*@Autowired
    private RestoranDao restoranDao;*/
    
    @Autowired
    private KorisnikDao korisnikDao;
    
    /*@Autowired
    private JeloDao jeloDao;*/
    
    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String printStudent(ModelMap model){
        return "pocetna";
    }
    @RequestMapping(value= "/pocetna", method = RequestMethod.GET)
    public String pocetna(ModelMap model){
        return "pocetna";
    }
    
    @RequestMapping(value = {"/korisnik"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana kojoj svi mogu da pristupe!");
        model.setViewName("korisnik");
        return model;
    }
    
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");
        return model;
    }
    
    @RequestMapping(value = {"/registracija",}, method = RequestMethod.GET)
    public String registracija(Model model) {

        model.addAttribute("korisnik", new Korisnik());

        return "registracija";
    }

    @RequestMapping(value = "/registracija", method = RequestMethod.POST)
    public ModelAndView registracija(@ModelAttribute("korisnik") Korisnik korisnik, ModelAndView model) {

        try {
            korisnik = korisnikDao.addKorisnik(korisnik);
            model.addObject("successMsg", "Uspešno ste se registrovali! Prijavite se za nastavak");
        } catch (RuntimeException r) {
            r.printStackTrace();
            model.addObject("successMsg", "Odaberite nepostojeci username!");
        }

        model.addObject("korisnik", korisnik);

        model.setViewName("registracija");
        return model;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout) {
 
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Losi login podaci!");
        }
 
        if (logout != null) {
            model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
 
        return model;
    }
    
    /*@RequestMapping(value = {"/dodajJelo",}, method = RequestMethod.GET)
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
    }*/
    
    /*@RequestMapping(value = {"/dodajRestoran",}, method = RequestMethod.GET)
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
    }*/
    
    /*@RequestMapping(value="/jelovnik", method=RequestMethod.GET)
    public String jelovnik(Model model) {
        List<Jelo> jela = jeloDao.getAllJela();
        model.addAttribute("jela", jela);
        return "jelovnik";
    }*/
        
    /*@RequestMapping(value="/rezervisanje", method = RequestMethod.GET)
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
    }*/
    
    /*@RequestMapping(value="/listaRezervacija", method=RequestMethod.GET)
    public ModelAndView listaRezervacija(ModelAndView modelAndView) {
        modelAndView.addObject("rez", rezervacijaDao.getAllRezervacije());
        modelAndView.addObject("rezervacija", new Rezervacija());
        return modelAndView;
    }*/
    
    @RequestMapping(value="/listaKorisnika", method=RequestMethod.GET)
    public ModelAndView listaKorisnika(ModelAndView modelAndView) {
        modelAndView.addObject("korisnici", korisnikDao.getAllKorisnici());
        modelAndView.addObject("users", new Korisnik());
        return modelAndView;
    }
    
    /*@RequestMapping(value="/listaRestorana", method=RequestMethod.GET)
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
    }*/
    
    /*@RequestMapping(value = "/deleteRezervaciju/{idRezervacije}", method = RequestMethod.GET)
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
    }*/
    
    @RequestMapping(value = "/deleteKorisnika/{idKorisnika}", method = RequestMethod.GET)
    public String deleteKorisnika(@PathVariable("idKorisnika") int idKorisnika, HttpServletRequest request) {
        System.out.println("Fetching & Deleting user with id " + idKorisnika);
        Korisnik kor = korisnikDao.getUserById(idKorisnika);
        if (kor == null) {
            System.out.println("Unable to delete. User with id " + idKorisnika + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        korisnikDao.deleteKorisnik(kor);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
    
    /*@RequestMapping(value = "/deleteJelo/{idJela}", method = RequestMethod.GET)
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
    }*/
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
 
        ModelAndView model = new ModelAndView();
 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }
}
