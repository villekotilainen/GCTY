package gcty.root.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gcty.root.Entities.Keikka;
import gcty.root.Repositories.KeikkaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/keikat")
public class KeikkaRestController {
    
    @Autowired
    private KeikkaRepository keikkaRepository;

    @GetMapping // GET: Hae kaikki tapahtumat
    public List<Keikka> getAllKeikat() {
        return keikkaRepository.findAll();
    }

    @GetMapping("/{id}") // GET: hae yksittäinen tapahtuma ID:n perusteella
    public ResponseEntity<Keikka> getKeikkaById(@PathVariable Long id) {
        Optional<Keikka> keikka = keikkaRepository.findById(id);
        return keikka.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping // POST: Lisää uusi tapahtuma
    public ResponseEntity<Keikka> createKeikka(@RequestBody Keikka newKeikka) {
        Keikka savedKeikka = keikkaRepository.save(newKeikka);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedKeikka);
    }

    @PutMapping("/{id}") // PUT: Päivitä olemassa oleva tapahtuma
    public ResponseEntity<Keikka> updateKeikka(@PathVariable Long id, @RequestBody Keikka keikkaDetails) {
        Optional<Keikka> optionalKeikka = keikkaRepository.findById(id);

        if (optionalKeikka.isPresent()) {
            Keikka existingKeikka = optionalKeikka.get();
            existingKeikka.setArtistit(keikkaDetails.getArtistit());
            existingKeikka.setVenue(keikkaDetails.getVenue());
            existingKeikka.setDate(keikkaDetails.getDate());
            existingKeikka.setStartTime(keikkaDetails.getStartTime());

            Keikka updatedKeikka = keikkaRepository.save(existingKeikka);
            return ResponseEntity.ok(updatedKeikka);
        } 
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    
    @DeleteMapping("/delete/{id}") // DELETE: Poista tapahtuma ID:n perusteella
    public ResponseEntity<Void> deleteKeikka(@PathVariable Long id) {
        if (keikkaRepository.existsById(id)) {
            keikkaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    
}
