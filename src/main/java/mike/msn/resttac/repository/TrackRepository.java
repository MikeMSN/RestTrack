package mike.msn.resttac.repository;

import mike.msn.resttac.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long>{
}
