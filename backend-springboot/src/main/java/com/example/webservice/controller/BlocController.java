package com.example.webservice.controller;

import com.example.webservice.entities.Bloc;
import com.example.webservice.entities.Foyer;
import com.example.webservice.services.IBlocService;
import com.example.webservice.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    IBlocService blocService;
   IFoyerService foyerService;
    @GetMapping("/retrieveBlocs")
     public List<Bloc> retrieveBlocs(){
         List<Bloc> Blocs = blocService.retrieveBlocs();
         return Blocs;
     }

     @PutMapping("/updateBloc")
     public Bloc updateBloc(@RequestBody Bloc b){
        Bloc bloc = blocService.updateBloc(b);
        return bloc ;
     }

     @PostMapping("addBloc")
     public Bloc addBloc(@RequestBody Bloc b){
        Bloc bloc = blocService.addBloc(b);
        return bloc;
     }

     @GetMapping("/retrieveBloc/{id-bloc}")
    public Bloc retrieveBloc(@PathVariable("id-bloc") Long idBloc){
        Bloc bloc = blocService.retrieveBloc(idBloc);
        return bloc;
    }

    @PostMapping("/addFoyerWithBloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer f){
        Foyer foyer = blocService.addFoyerWithBloc(f);
        return foyer;

    }


}
