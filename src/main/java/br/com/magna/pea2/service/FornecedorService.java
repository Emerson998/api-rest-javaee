package br.com.magna.pea2.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;

import br.com.magna.pea2.dao.FornecedorDao;
import br.com.magna.pea2.dto.FornecedorDto;
import br.com.magna.pea2.model.FornecedorModel;

@Named
public class FornecedorService {

	@Inject
	private FornecedorDao fornecedorDao;

	private ModelMapper modelMapper = new ModelMapper();

	private static final Logger log = Logger.getLogger(FornecedorService.class.getName());

	public List<FornecedorDto> all() {
		try {
			log.info("Buscando Todos Fornecedores cadastrados ");
			List<FornecedorDto> every = new ArrayList<FornecedorDto>();
			List<FornecedorModel> customers = fornecedorDao.getAll();
			for (FornecedorModel customer : customers) {
				every.add(modelMapper.map(customer, FornecedorDto.class));
			}
			return every;
		} catch (Exception ex) {
			log.error("Não há fornecedores cadastrados !");
			throw ex;
		}
	}

	public FornecedorDto searchByCnpj(String cnpj) {
		try {
			log.info("Buscando Fornecedor com cnpj " + cnpj);
			FornecedorDto dto = new FornecedorDto();
			FornecedorModel model = fornecedorDao.getByCnpj(cnpj);
			dto = modelMapper.map(model, FornecedorDto.class);
			log.info("Nao existe Fornecedor com cnpj " + cnpj);
			return dto;
		} catch (Exception ex) {
			log.error("Nenhum Fornecedor Cadastrado com o cnpj " + cnpj);
			throw ex;
		}
	}

	public FornecedorModel saveFornecedorDao(FornecedorModel fornecedor) {
		try {
			log.info("Cadastrando Fornecedor : " + fornecedor.getCnpj());
			FornecedorModel fornecedorSalvo = fornecedorDao.save(fornecedor);
			log.info("Fornecedor Cadastrado Com Sucesso");
			return fornecedorSalvo;
		} catch (Exception ex) {
			log.error("Fornecedor não cadastrado !");
			throw ex;
		}
	}

	public FornecedorDto change(String cnpj, FornecedorDto fornecedorDto) {
		try {
			log.info("Atualizando Fornecedor : " + fornecedorDto.getCnpj());
			FornecedorModel model = fornecedorDao.getByCnpj(cnpj);
			model.setCnpj(fornecedorDto.getCnpj());
			model.setEndereco(fornecedorDto.getEndereco());
			model.setSenha(fornecedorDto.getSenha());
			model.setData(fornecedorDto.getData());
			fornecedorDao.atualizar(model);
			FornecedorDto dto = modelMapper.map(model, FornecedorDto.class);
			log.info("Fornecedor atualizado com sucesso ");
			return dto;
		} catch (EntityNotFoundException ex) {
			log.error("Fornecedor não cadastrado");
			throw ex;
		} catch (Exception ex) {
			log.error("Erro na atualizacao !!! ");
			throw ex;
		}
	}

	public void delete(String cnpj) {
		try {
			log.info("Removendo Fornecedor: " + cnpj);
			FornecedorModel model = fornecedorDao.getByCnpj(cnpj);
			fornecedorDao.delete(model);
			log.info("Remocao concluida com sucesso ");
		} catch (Exception ex) {
			log.error("Fornecedor nao foi removido, cnpj nao cadastrado : " + cnpj);
			throw ex;
		}
	}
}
