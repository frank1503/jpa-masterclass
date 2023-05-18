package jpa.rest;

import jpa.repository.VoetbalClubRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/voetbalclubs")
public class VoetbalClubController {

    private VoetbalClubRepositroy voetbalClubRepositroy;

    @Autowired
    public VoetbalClubController(VoetbalClubRepositroy voetbalClubRepositroy) {
        this.voetbalClubRepositroy = voetbalClubRepositroy;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<VoetbalClubView> vindOpId(@PathVariable("id") int id) {
//        VoetbalClub voetbalClub = voetbalClubRepositroy.vindVoetbalClubOpId(id);
//
//        if (voetbalClub != null) {
//            return new ResponseEntity<>(VoetbalClubMapper.mapToVoetbalClubView(voetbalClub), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{id}/spelers")
//    public ResponseEntity<VoetbalClubView> vindClubEnSpelersOpId(@PathVariable("id") int id) {
//        VoetbalClub voetbalClub = voetbalClubRepositroy.zoekVoetbalClubEnSpelers(id);
//
//        if (voetbalClub != null) {
//            return new ResponseEntity<>(VoetbalClubMapper.mapMetSpelers(voetbalClub), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<VoetbalClubView> vindOpNaam(@RequestParam String naam) {
//        Optional<VoetbalClub> voetbalClub = voetbalClubRepositroy.zoekVoetbalClubOpNaam(naam);
//
//        return voetbalClub.map(club -> new ResponseEntity<>(VoetbalClubMapper.mapToVoetbalClubView(club), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<Integer> slaOp(@RequestBody VoetbalClubCommand voetbalClubCommand) {
//        int id = voetbalClubRepositroy.slaVoetbalClubOp(voetbalClubCommand.mapToVoetbalClub());
//
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }
//
//    @DeleteMapping
//    public void verwijderOpNaam(@RequestParam String naam) {
//        voetbalClubRepositroy.verwijderVoetbalClub(naam);
//    }
}
