package be.vdab.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;

public class WinstServiceTest {
	private WinstService winstService;
	private OpbrengstRepository opbrengstRepository;
	private KostRepository kostRepository;
	@Before
	public void before() {
		opbrengstRepository = mock(OpbrengstRepository.class);
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(200));
		kostRepository = mock(KostRepository.class);
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(169));
		winstService = new WinstService(opbrengstRepository, kostRepository);
	}
	@Test
	public void winstIsOpbrengstMinKost() {
		assertEquals(0, BigDecimal.valueOf(31).compareTo(winstService.getWinst()));
		verify(opbrengstRepository).findTotaleOpbrengst();
	}

}
