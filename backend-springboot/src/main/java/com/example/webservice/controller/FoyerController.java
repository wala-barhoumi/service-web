package com.example.webservice.controller;

import com.example.webservice.entities.Foyer;
import com.example.webservice.entities.TunisianGovernorate;
import com.example.webservice.entities.TypeFoyer;
import com.example.webservice.services.IFoyerService;
import com.example.webservice.services.IUniversiteService;
import com.example.webservice.services.QRCodeService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
@CrossOrigin("*")
public class FoyerController {
    IFoyerService foyerService;
    IUniversiteService universiteService;

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> retrieveAllFoyers() {
        List<Foyer> foyerList = foyerService.retrieveAllFoyers();
        return foyerList;
    }

    @PostMapping("addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    @PutMapping("updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.updateFoyer(f);
        return foyer;
    }

    @GetMapping("/retrieveFoyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/removeFoyer")
    void removeFoyer(@PathVariable("foyer-id") Long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }

    @DeleteMapping("/archiverFoyer/{foyer-id}")
    void archiverFoyer(@PathVariable("foyer-id") Long idFoyer) {
        foyerService.archiverFoyer(idFoyer);
    }

    @GetMapping("/qrcode")
    public void generateQRCode(HttpServletResponse response,
                               @RequestParam String text,
                               @RequestParam(defaultValue = "350") int width,
                               @RequestParam(defaultValue = "350") int height) throws Exception {
        BufferedImage image = qrCodeService.generateQRCode(text, width, height);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping("/retrieve-all-type")
    @ResponseBody
    public TypeFoyer[] getDepartments() {
        return TypeFoyer.values();
    }


    @GetMapping("/retrieveAllFoyers/byGrouvenerat/{grouvenerat}")
    public List<Foyer> getAllFoyersByGrouvenerat(@PathVariable TunisianGovernorate grouvenerat) {
        List<Foyer> foyerList = foyerService.getAllFoyersByGrouvenerat(grouvenerat);
        return foyerList;
    }

    @GetMapping("/countByGrouvenerat")
    public ResponseEntity<Map<TunisianGovernorate, Long>> countFoyersByGrouvenerat() {
        Map<TunisianGovernorate, Long> counts = new HashMap<>();

        for (TunisianGovernorate gouvernerat : TunisianGovernorate.values()) {
            Long count = foyerService.countFoyersByGrouvenerat(gouvernerat);
            counts.put(gouvernerat, count);
        }

        return new ResponseEntity<>(counts, HttpStatus.OK);
    }

    @GetMapping("/countByGrouveneratNombre")
    public ResponseEntity<ArrayList> countFoyersByGrouveneratNombre() {
        ArrayList counts = new ArrayList<>();

        for (TunisianGovernorate gouvernerat : TunisianGovernorate.values()) {
            Long count = foyerService.countFoyersByGrouvenerat(gouvernerat);
            counts.add(count);
        }

        return new ResponseEntity<>(counts, HttpStatus.OK);
    }


    //http://localhost:8099/foyer/foyer/byType/HOMMES
    @GetMapping("/byType/{type}")
    public ResponseEntity<List<Foyer>> getFoyersByType(@PathVariable TypeFoyer type) {
        List<Foyer> foyers = foyerService.getFoyersByType(type);

        if (!foyers.isEmpty()) {
            return new ResponseEntity<>(foyers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/countByType")
    public ResponseEntity<Map<TypeFoyer, Long>> countFoyersByType() {
        Map<TypeFoyer, Long> counts = foyerService.countFoyersByType();

        if (!counts.isEmpty()) {
            return new ResponseEntity<>(counts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
