package br.com.dperricci.financeiro.despesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dperricci.financeiro.despesas.controller.dto.CategoriaDto;
import br.com.dperricci.financeiro.despesas.service.CategoriaException;
import br.com.dperricci.financeiro.despesas.service.CategoriaService;

@RestController("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@PostMapping
	public ResponseEntity<CategoriaDto> salvar(@RequestBody CategoriaDto categoriaDto) {
		CategoriaDto dto = service.salvar(categoriaDto);
		if (dto == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(dto);
	}

	@PutMapping
	public ResponseEntity<CategoriaDto> atualizar(@RequestBody CategoriaDto categoriaDto) {
		try {
			CategoriaDto dto = service.atualizar(categoriaDto);
			if (dto == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(dto);
		} catch (CategoriaException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/categoria/lista")
	public List<CategoriaDto> listaCategorias() {
		return service.listarCategorias();
	}
}
