package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ifms.dto.EscolaDTO;
import com.ifms.entities.Escola;
import com.ifms.repositories.escolaRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class EscolaService {

	@Autowired
	private escolaRepository repository;

	@Transactional(readOnly = true)
	public List<EscolaDTO> findAll() {
		List<Escola> list = repository.findAll();
		return list.stream().map(escola -> new EscolaDTO(escola)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EscolaDTO findById(Long id) {
		Optional<Escola> obj = repository.findById(id);
		Escola escola = obj
				.orElseThrow(() -> new ResourceNotFoundException("escola SOLICITADA NAO PODE SER ENCONTRADA!!"));
		return new EscolaDTO(escola);
	}

	@Transactional
	public EscolaDTO insert(EscolaDTO dto) {
		Escola entity = new Escola();
		entity.setNome(dto.getNome());
		entity = repository.save(entity);
		return new EscolaDTO(entity);
	}

	@Transactional
	public EscolaDTO update(Long id, EscolaDTO dto) {

		try {
			Escola entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity = repository.save(entity);
			return new EscolaDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("escola nao Encontrada");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("escola nao Encontrada");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Nao foi possivel Deletar a escola, Pois ainda possui Times restrados nela.");
		}
	}

}
