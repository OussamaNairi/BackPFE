package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IPfeDao;
import tn.essat.model.Categorie;
import tn.essat.model.Pfe;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/rest")
public class AppRest {

	    @Autowired
		IPfeDao daop;
		@Autowired
		ICategorieDao daoc;
		
		
		@GetMapping("/listedepfe")
		public List<Pfe> get1(){
			return daop.findAll();
		}
		@GetMapping("/categorie")
		public List<Categorie> get2(){
			List<Categorie> liste =  daoc.findAll();
			for (Categorie categorie : liste) {
				categorie.setPfe(categorie.getPfe());		
			}
			return liste;
		}
		@DeleteMapping("/deletepfe/{id}")
		public void get3(@PathVariable("id") int id){
			daop.deleteById(id);	
		}
		@GetMapping("/pfebycategorie/{id}")
		public List<Pfe> get4(@PathVariable("id") int id){
			return daop.getAllPfeByCategorie(id);		
		}
		@PostMapping("/addpfe")
		public void get5(@RequestBody Pfe m) {
			
			daop.save(m);
		}

}
