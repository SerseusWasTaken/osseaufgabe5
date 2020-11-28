package de.hfu.residents;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class TestStubResident {
	@Test
	public void testFilteredResidentsList() {
		BaseResidentService base = new BaseResidentService();
		Resident filter = new Resident();
		filter.setFamilyName("Müller");
		filter.setDateOfBirth(new Date(123456));
		StubResidentRepository repo = new StubResidentRepository();
		base.setResidentRepository(repo);
		assertEquals(2, base.getFilteredResidentsList(filter).size());
		assertEquals(3, base.getFilteredResidentsList(new Resident()).size());
		filter = new Resident();
		filter.setStreet("H*");
		assertEquals(3, base.getFilteredResidentsList(filter).size());
	}

	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository repo = new StubResidentRepository();

		Resident filter = new Resident();
		filter.setGivenName("Jonas");
		Resident control = new Resident("Jonas", "Müller", "Hauptsrasse", "Rottweil", new Date(123456));

		base.setResidentRepository(repo);

		Resident ergebnis = base.getUniqueResident(filter);
		assertEquals(control, ergebnis);
	}

	@Test(expected = ResidentServiceException.class, timeout = 1000)
	public void testExceptionUniqueResident() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository repo = new StubResidentRepository();
		base.setResidentRepository(repo);
		
		Resident filter = new Resident();
		filter.setStreet("Heerstrasse");
		base.getUniqueResident(filter);
	}
	@Test(expected = ResidentServiceException.class, timeout = 1000)
	public void testWildcadUniqueResident() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository repo = new StubResidentRepository();
		base.setResidentRepository(repo);
		
		Resident filter = new Resident();
		filter.setStreet("H*");
		base.getUniqueResident(filter);
	}

}
