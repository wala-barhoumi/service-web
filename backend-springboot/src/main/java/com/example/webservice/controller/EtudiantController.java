package com.example.webservice.controller;

import com.example.webservice.entities.Etudiant;
import com.example.webservice.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiant")
    List<Etudiant> retrieveAllEtudiants(){
        List<Etudiant>listEtudiants=etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    };

    @PostMapping("/addetudiant")
        public Etudiant addEtudiant(@RequestBody Etudiant e) {
            Etudiant etudiant = etudiantService.addEtudiant(e);
            return etudiant;
    };

    @PutMapping("/updateetudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= etudiantService.updateEtudiant(e);
        return etudiant;
    }



    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    @DeleteMapping("/remouve-etudiant/{etudiant-id}")
    void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId){

            etudiantService.removeEtudiant(etudiantId);
    };

    @PutMapping("/affecterEtudiantAReservation/{nom-et}/{prenom-et}/{id-reservation}")
    public Etudiant affecterEtudiantAReservation(@PathVariable("nom-et") String nomEt,@PathVariable("prenom-et")String prenomEt,@PathVariable("id-reservation")Long idReservation){
        etudiantService.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);
        return null;
    }



}
