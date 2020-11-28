package de.hfu.residents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class StubResidentRepository implements ResidentRepository {
	List<Resident> bewohner = new ArrayList<Resident>();
	 public StubResidentRepository() {
		super();
		bewohner.add(new Resident("Jonas", "Müller", "Hauptsrasse", "Rottweil", new Date(123456)));
		bewohner.add(new Resident("Coco", "Sailer", "Heerstrasse", "Rottweil", new Date()));
		bewohner.add(new Resident("Tobi", "Müller", "Heerstrasse", "Furtwangen", new Date(123456)));
	}
	 
	public List<Resident> getResidents() {
		return bewohner; 
	 }
}
