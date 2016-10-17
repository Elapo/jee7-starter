package com.realdolmen;

import static org.junit.Assert.assertNotNull;

import com.realdolmen.course.service.FortuneCookieService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

public class Demo {

	private WeldContainer container;

	@Before
	public void init(){
		Weld weld = new Weld();
		container = weld.initialize();
	}

	@Test
	public void fortuneYieldsProfaneMessage() {
		FortuneCookieService fcs = container.instance().select(FortuneCookieService.class).get();
		String message = fcs.crack();
		assertNotNull(message); //reasonable proof
		System.out.println(message);
	}
}