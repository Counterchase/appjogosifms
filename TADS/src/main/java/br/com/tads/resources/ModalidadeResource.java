package br.com.tads.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tads.entities.Modalidade;

@RestController
@RequestMapping(value = "/modalidades")
public class ModalidadeResource {
	
	@GetMapping
	public ResponseEntity<List<Modalidade>> findAll(){
		List<Modalidade> lista = new ArrayList<>();
		lista.add(new Modalidade(1L, "Futsal"));
		lista.add(new Modalidade(2L, "BaseBall"));
		lista.add(new Modalidade(3L, "Basket"));
		return ResponseEntity.ok().body(lista);
	}
	
}
