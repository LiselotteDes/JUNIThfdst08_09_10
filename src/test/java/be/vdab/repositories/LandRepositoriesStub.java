package be.vdab.repositories;

import be.vdab.entities.Land;
import be.vdab.repositories.LandRepository;

public class LandRepositoriesStub implements LandRepository {
//	@Override
	public Land read(String landcode) {
		return new Land(landcode, 5);
	}
//	@Override
	public int findOppervlakteAlleLanden() {
		return 20;
	}

}
