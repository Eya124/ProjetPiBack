package tn.esprit.projetpiback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.dto.CentreDto;
import tn.esprit.projetpiback.dto.EvenementDto;
import tn.esprit.projetpiback.services.CentreService;

import java.util.List;

@RestController
@RequestMapping("/api/centres")
public class CentreController {

    @Autowired
    private CentreService centreService;


    public CentreController ()
    {
        super();
    }

    @PostMapping
    public ResponseEntity<CentreDto> CreateCentre(@RequestBody CentreDto request){
        CentreDto requestDto = this.centreService.createCentre(request);
        return new ResponseEntity<>(requestDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CentreDto>> getAll(){
        List<CentreDto> list = this.centreService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CentreDto> delete (@PathVariable("id") int id){
        return new ResponseEntity<>(this.centreService.deleteCentre(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CentreDto> getById (@PathVariable("id") int id){
        return new ResponseEntity<>(this.centreService.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CentreDto> updateCentre (@RequestBody CentreDto request, @PathVariable("id") int id){
        return new ResponseEntity<>(this.centreService.updateCentre(id, request), HttpStatus.OK);
    }

    @GetMapping("eventList/{id}")
    public ResponseEntity<List<EvenementDto>> getEventByCentreId(@PathVariable("id") int id){
        return new ResponseEntity<>(this.centreService.getEventByCentreId(id), HttpStatus.OK);
    }


}
