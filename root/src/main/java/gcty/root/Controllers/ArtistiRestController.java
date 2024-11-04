package gcty.root.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gcty.root.Repositories.ArtistiRepository;
import gcty.root.Entities.Artisti;

@RestController
@RequestMapping("/api/artistit")
public class ArtistiRestController {
    
    @Autowired
    private ArtistiRepository artistiRepository;

    @GetMapping // GET: hae kaikki artistit
    public List<Artisti> getAllArtistit() {
            return artistiRepository.findAll();
    }

    @GetMapping("/{id}") // GET: hae tietty artisti ID:n perusteella
    public ResponseEntity<Artisti> getArtistiById(@PathVariable Long id) {
        Optional<Artisti> artisti = artistiRepository.findById(id);
        return artisti.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping // POST: Lisää uusi artisti
    public ResponseEntity<Artisti> createArtist(@RequestBody Artisti newArtisti) {
        Artisti savedArtisti = artistiRepository.save(newArtisti);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArtisti);
    }

    @PutMapping("/{id}") // PUT: päivitä olemassa oleva artisti
    public ResponseEntity<Artisti> updateArtisti(@PathVariable Long id, @RequestBody Artisti artistiDetails){
        Optional<Artisti> optionalArtisti = artistiRepository.findById(id);

        if (optionalArtisti.isPresent()) {
            Artisti existingArtisti = optionalArtisti.get();

            existingArtisti.setArtistiName(artistiDetails.getArtistiName());

            Artisti updatedArtisti = artistiRepository.save(existingArtisti);
            return ResponseEntity.ok(updatedArtisti);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}") // DELETE: Poista artisti ID:n perusteella
    public ResponseEntity<Void> deleteArtisti(@PathVariable Long id) {
        if (artistiRepository.existsById(id)) {
            artistiRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
