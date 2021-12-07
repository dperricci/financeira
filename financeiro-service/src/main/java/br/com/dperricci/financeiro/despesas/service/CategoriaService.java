package br.com.dperricci.financeiro.despesas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dperricci.financeiro.despesas.controller.dto.CategoriaDto;
import br.com.dperricci.financeiro.despesas.entity.Categoria;
import br.com.dperricci.financeiro.despesas.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepo;

	public CategoriaDto salvar(CategoriaDto categoriaDto) {
		Categoria entity = new Categoria();
		entity.toEntity(categoriaDto);
		return new CategoriaDto(categoriaRepo.save(entity));
	}

	public CategoriaDto atualizar(CategoriaDto categoriaDto) throws CategoriaException {
		Categoria entity = categoriaRepo.findById(categoriaDto.getId()).get();
		if (entity == null) {
			throw new CategoriaException("Não foi possível atualizar o registro " + categoriaDto.getId());
		}
		entity = entity.toEntity(categoriaDto);
		return new CategoriaDto(categoriaRepo.save(entity));
	}

	public List<CategoriaDto> listarCategorias() {
		List<Categoria> categorias = categoriaRepo.findAll();
		return new CategoriaDto().toDto(categorias);
	}

	public CategoriaDto listarCategoriaPorId(Long id) {
		Optional<Categoria> categorias = categoriaRepo.findById(id);
		return new CategoriaDto(categorias.get());
	}

	public CategoriaDto listarCategoriaPorDescricao(String descricao) {
		Categoria categoria = categoriaRepo.findByDescricao(descricao);
		return new CategoriaDto(categoria);
	}
}
