package pl.tecna.test.metamodel;

import java.util.List;

import javax.persistence.*;
/*
 * W metamodelu starałem się całość jak najbardziej skrócić - nie dodawać 
 * niepotrzebnych powiązań i pól.
 */
@Entity
public class Uczen {
	String imie;
			@Id
	    @GeneratedValue
	    Integer id;
			
		@ManyToOne
		Klasa klasa;
		
		@OneToMany
		List<UczniowieZapisani> ZapisanyNa;

		
}
