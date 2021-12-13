package br.com.magna.pea2.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;

import br.com.magna.pea2.dao.LocadoraDao;
import br.com.magna.pea2.dto.LocadoraDto;
import br.com.magna.pea2.model.LocadoraModel;

@Named
public class LocadoraService {

	@Inject
	private LocadoraDao locadoraDao;

	private ModelMapper modelMapper = new ModelMapper();

	private static final Logger log = Logger.getLogger(LocadoraService.class.getName());

	public List<LocadoraDto> all() {
		try {
			log.info("Buscando Todas Locadoras cadastradas ");
			List<LocadoraDto> every = new ArrayList<LocadoraDto>();
			List<LocadoraModel> customers = locadoraDao.getAll();
			for (LocadoraModel customer : customers) {
				every.add(modelMapper.map(customer, LocadoraDto.class));
			}
			return every;
		} catch (Exception ex) {
			log.error("Não há Locadoras cadastradas !");
			throw ex;
		}
	}

	public LocadoraDto searchByCnpj(String cnpj) {
		try {
			log.info("Buscando Locadora com cnpj " + cnpj);
			LocadoraDto dto = new LocadoraDto();
			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			dto = modelMapper.map(model, LocadoraDto.class);
			return dto;
		} catch (Exception ex) {
			log.error("Nenhuma Locadora cadastrada com o cnpj " + cnpj);
			throw ex;
		}
	}

	public LocadoraModel saveLocadoraDao(LocadoraModel locadora) {
		try {
			log.info("Cadastrando Locadora : " + locadora.getCnpj());
			LocadoraModel locadoraSalvo = locadoraDao.save(locadora);
			log.info("Locadora Cadastrada Com Sucesso");
			return locadoraSalvo;
		} catch (EntityNotFoundException ex) {
			log.error("Locadora não cadastrada  !");
			throw ex;
		} catch (Exception ex) {
			log.error("Locadora não cadastrada !");
			throw ex;
		}
	}

	public LocadoraDto change(String cnpj, LocadoraDto locadoraDto) {
		try {
			log.info("Atualizando Locadora : " + locadoraDto.getCnpj());
			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			model.setCnpj(locadoraDto.getCnpj());
			model.setSenha(locadoraDto.getSenha());
			model.setEndereco(locadoraDto.getEndereco());
			model.setData(locadoraDto.getData());
			locadoraDao.change(model);
			LocadoraDto dto = modelMapper.map(model, LocadoraDto.class);
			log.info("Locadora atualizada com sucesso");
			return dto;
		} catch (EntityNotFoundException ex) {
			log.error("Locadora não cadastrada");
			throw ex;
		} catch (Exception ex) {
			log.error("Erro na atualizacao !!! ");
			throw ex;
		}
	}

	public void delete(String cnpj) {
		try {
			log.info("Removendo Locadora: " + cnpj);
			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			locadoraDao.delete(model);
			log.info("Remocao concluida com sucesso");
		} catch (Exception ex) {
			log.error("Locadora nao foi removida, cnpj nao cadastrado : " + cnpj);
			throw ex;
		}
	}

}
