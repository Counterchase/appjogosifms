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

import com.ifms.dto.ModalidadeDTO;
import com.ifms.entities.Modalidade;
import com.ifms.repositories.modalidadeRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class ModalidadeService {

	@Autowired
	private modalidadeRepository repository;

	@Transactional(readOnly = true)
	public List<ModalidadeDTO> findAll() {
		List<Modalidade> list = repository.findAll();
		return list.stream().map(modalidade -> new ModalidadeDTO(modalidade)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ModalidadeDTO findById(Long id) {
		Optional<Modalidade> obj = repository.findById(id);
		Modalidade modalidade = obj
				.orElseThrow(() -> new ResourceNotFoundException("MODALIDADE SOLICITADA NAO PODE SER ENCONTRADA!!"));
		return new ModalidadeDTO(modalidade);
	}

	@Transactional
	public ModalidadeDTO insert(ModalidadeDTO dto) {
		Modalidade entity = new Modalidade();
		entity.setDescricao(dto.getDescicao());
		entity = repository.save(entity);
		return new ModalidadeDTO(entity);
	}

	@Transactional
	public ModalidadeDTO update(Long id, ModalidadeDTO dto) {

		try {
			Modalidade entity = repository.getOne(id);
			entity.setDescricao(dto.getDescicao());
			entity = repository.save(entity);
			return new ModalidadeDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Modalidade nao Encontrada");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Modalidade nao Encontrada");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Nao foi possivel Deletar a Modalidade, Pois ainda possui Times restrados nela.");
		}
	}

}
