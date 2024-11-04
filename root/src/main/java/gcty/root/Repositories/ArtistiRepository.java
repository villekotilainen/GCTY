package gcty.root.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gcty.root.Entities.Artisti;
import java.util.List;

@Repository
public interface ArtistiRepository extends JpaRepository<Artisti, Long> {

    Artisti findByArtistiName(String artistiName);
    
    Artisti findByArtistiWebsite(String artistiWebsite);
    
    Artisti findByArtistiDescription(String artistiDescription);

    List<Artisti> findByArtistiGenre(String artistiGenre);

    List<Artisti> findByArtistiHomeCountry(String artistiHomeCountry);
}
