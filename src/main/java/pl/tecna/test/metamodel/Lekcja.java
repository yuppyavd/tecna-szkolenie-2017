package pl.tecna.test.metamodel;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

//import antlr.collections.List;

@Entity
public class Lekcja {
	String nazwaZajec = new String();
	Date data;
	Time time;
	String powtarzalnoscWTygodniu;
	
	@Id
	@GeneratedValue
	Integer IdLekcji;
	
	@OneToMany
	List<UczniowieZapisani> uczniowieZapisani;
	
}
