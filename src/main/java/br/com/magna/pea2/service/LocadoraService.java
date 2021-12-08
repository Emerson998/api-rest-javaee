package br.com.magna.pea2.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import br.com.magna.pea2.dao.LocadoraDao;
import br.com.magna.pea2.dto.LocadoraDto;
import br.com.magna.pea2.model.LocadoraModel;

@Named
public class LocadoraService {

	@Inject
	private LocadoraDao locadoraDao;

	private ModelMapper modelMapper = new ModelMapper();

	public LocadoraDto searchByCnpj(String cnpj) {
		try {
			LocadoraDto dto = new LocadoraDto();
			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			dto = modelMapper.map(model, LocadoraDto.class);
			return dto;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public List<LocadoraDto> all() {
		try {
			List<LocadoraDto> every = new ArrayList<LocadoraDto>();
			List<LocadoraModel> customers = locadoraDao.getAll();
			for (LocadoraModel customer : customers) {
				every.add(modelMapper.map(customer, LocadoraDto.class));
			}
			return every;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public LocadoraModel saveLocadoraDao(LocadoraModel locadora) {
		try {
			LocadoraModel locadoraSalvo = locadoraDao.save(locadora);
			return locadoraSalvo;
		} catch (Exception e) {
			throw e;
		}
	}

	public LocadoraDto update(String cnpj, LocadoraDto locadoraDto) {
		try {

			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			model.setCnpj(locadoraDto.getCnpj());
			model.setEndereco(locadoraDto.getEndereco());
			model.setNomeDvd(locadoraDto.getNomeDvd());
			model.setData(locadoraDto.getData());
			locadoraDao.atualizar(model);
			LocadoraDto dto = modelMapper.map(model, LocadoraDto.class);
			return dto;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void delete(String cnpj) {
		try {
			LocadoraModel model = locadoraDao.getByCnpj(cnpj);
			locadoraDao.delete(model);
		} catch (Exception ex) {
			throw ex;
		}
	}

}
