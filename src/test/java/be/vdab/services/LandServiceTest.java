package be.vdab.services;
import static org.junit.Assert.assertEquals;
/*
 * Alle functionaliteit die je oproept op Mockito, zijn oproepen van static methods 
 * op de class Mockito.
 * Deze oproepen zijn kort (en dus leesbaar) met deze import static.
 */
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.entities.Land;
//import be.vdab.repositories.LandRepositoriesStub;
import be.vdab.repositories.LandRepository;

public class LandServiceTest {
	private LandRepository landRepository;
	private LandService landService;
	@Before
	public void before() {
		// MEMBER-VARIABELEN INITIALISEREN
		// Maakt een stub.
//		landRepository = new LandRepositoriesStub();
		/*
		 * Vervangt bovenstaande opdracht de stub door een mock:
		 * Je maakt een mock met de static Mockito method mock.
		 * Je geeft als parameter een interface mee.
		 * De method mock maakt een class die deze interface implementeert.
		 * De method mock maakt daarna een object van deze class en geeft je dit object (de mock) als returnwaarde.
		 * De variabele landRepository verwijst dus naar een mock waarvan de class de interface LandRepository implementeert.
		 */
		landRepository = mock(LandRepository.class);
		// MOCK TRAINEN
		/*
		 * Je traint een mock met de static Mockito method when.
		 * Je geeft als parameter de variabele mee die naar de mock wijst, gevolgd door de method van die mock.
		 * De method when geeft je een OnGoingStubbing object terug.
		 * Je roept daarna de method thenReturn op.
		 * Je geeft de waarde mee die de mock method moet teruggeven.
		 * De mock zal dus de waarde 20 teruggeven als je de method findOppervlakteAlleLanden op uitvoert.
		 */
		when(landRepository.findOppervlakteAlleLanden()).thenReturn(20);
		/*
		 * Traint de mock zodat hij een Land object met een landcode "B" en een oppervlakte 5 teruggeeft 
		 * als je op de mock de method read oproept met een parameter "B".
		 */
		when(landRepository.read("B")).thenReturn(new Land("B",5));
		// INITIALISEREN
		// Geeft deze stub/mock mee aan de constructor van de te testen class (dependency injection).
		landService = new LandService(landRepository);
	}
	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLanden() {
		// Op basis van de data in de stub moet de verhouding 0.25 zijn.
		assertEquals(0, BigDecimal.valueOf(0.25).compareTo(landService.findVerhoudingOppervlakteTovOppervlakteAlleLanden("B")));
		// Hier gaan we straks verifi�ren of landService de methods read("B") en findOppervlakteAlleLanden() heeft opgeroepen op landRepository.
		
		// VERIFICATIES
		/*
		 * Je verifieert met de static Mockito method verify.
		 * Je geeft als parameter de mock mee. 
		 * Je krijgt een object terug. Je geeft hierop aan welke method oproep moet gebeurd zijn.
		 * Als dit niet het geval is, mislukt de test.
		 */
		verify(landRepository).findOppervlakteAlleLanden();
		verify(landRepository).read("B");
	}

}
