package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.repositories.LandRepository;

public class LandService {
	private final LandRepository landRepository;
	/*
	 * Dependency injection:
	 * Je geeft aan de constructor een object mee waarvan de class LandRepository implementeert.
	 * Deze class maakt dus zelf geen object meer dat de dependency voorstelt, 
	 * maar krijgt dit object aangereikt.
	 * Per dependency bevat een class een extra parameter in de constructor.
	 */
	public LandService(LandRepository landRepository) {
		this.landRepository = landRepository;
	}
	public BigDecimal findVerhoudingOppervlakteTovOppervlakteAlleLanden(String landcode) {
		return new BigDecimal(landRepository.read(landcode).getOppervlakte()).divide(BigDecimal.valueOf(landRepository.findOppervlakteAlleLanden()));
	}
}
