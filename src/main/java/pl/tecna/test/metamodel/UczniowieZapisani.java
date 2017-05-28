package pl.tecna.test.metamodel;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UczniowieZapisani {
	@Id
	@ManyToOne
	Uczen uczen;
	@Id
	@ManyToOne
	Lekcja lekcja;
	@OneToMany
	List<ListaObecnosci> ListaObecnosci;
}
