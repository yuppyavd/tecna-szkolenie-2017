package pl.tecna.test.metamodel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ListaObecnosci {

	String obecnosc;
	@Id
	@ManyToOne
	UczniowieZapisani listaZapisanych;
	@Id
	Date data;
}
