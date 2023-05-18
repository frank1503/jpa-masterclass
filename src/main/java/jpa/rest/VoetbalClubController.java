package jpa.rest;

import jpa.domain.VoetbalClub;
import jpa.repository.VoetbalClubRepositroy;
import jpa.rest.commands.VoetbalClubCommand;
import jpa.rest.views.mappers.VoetbalClubMapper;
import jpa.rest.views.VoetbalClubView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/voetbalclubs")
public class VoetbalClubController {

    private VoetbalClubRepositroy voetbalClubRepositroy;

    @Autowired
    public VoetbalClubController(VoetbalClubRepositroy voetbalClubRepositroy) {
        this.voetbalClubRepositroy = voetbalClubRepositroy;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoetbalClubView> vindOpId(@PathVariable("id") int id) {
        VoetbalClub voetbalClub = voetbalClubRepositroy.vindVoetbalClubOpId(id);

        return new ResponseEntity<>(VoetbalClubMapper.mapToVoetbalClubView(voetbalClub), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<VoetbalClubView> vindOpNaam(@RequestParam String naam) {
        Optional<VoetbalClub> voetbalClub = voetbalClubRepositroy.zoekVoetbalClubOpNaam(naam);

        return voetbalClub.map(club -> new ResponseEntity<>(VoetbalClubMapper.mapToVoetbalClubView(club), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void slaOp(@RequestBody VoetbalClubCommand voetbalClubCommand) {
        voetbalClubRepositroy.slaVoetbalClubOp(voetbalClubCommand.mapToVoetbalClub());
    }
}
