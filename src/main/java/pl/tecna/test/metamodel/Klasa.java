package pl.tecna.test.metamodel;

import java.util.List;

import javax.persistence.*;

@Entity
public class Klasa {
	String nazwa = new String();
	@Id
	@GeneratedValue
	Integer IdKlasy;
	
	@OneToMany
	List<Uczen> uczniowie;
}
