package be.vdab.repositories;
import be.vdab.entities.Land;

public interface LandRepository {
	Land read(String landcode);
	int findOppervlakteAlleLanden();
}
