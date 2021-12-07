package br.com.magna.pea2.service;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.magna.pea2.dao.LocadoraDao;
import br.com.magna.pea2.model.LocadoraModel;

@Named
public class LocadoraService {

	@Inject
	private LocadoraDao locadoraDao;
	
	//private ModelMapper modelMapper = new ModelMapper();
	
	public LocadoraModel salvarLocadoraDao(LocadoraModel locadora) {
		LocadoraModel locadoraSalvo = locadoraDao.save(locadora);
		return locadoraSalvo;
	}
	
//	public void add(LocadoraDto LocadoraDto) {
//		LocadoraModel locadoraModel = modelMapper.map(locadoraDto, LocadoraModel.class);
//	    locadoraDao.post(locadoraModel);
//		locadoraDto = modelMapper.map(locadoraModel, LocadoraDto.class);
//	}
	
}
