package br.com.magna.pea2.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.magna.pea2.dao.ClienteDao;
import br.com.magna.pea2.dto.ClienteDto;
import br.com.magna.pea2.model.ClienteModel;

@Named
public class ClienteService {

	@Inject
	private ClienteDao clienteDao;

	private ModelMapper modelMapper = new ModelMapper();

	private static final Logger log = Logger.getLogger(ClienteService.class.getName());

	public List<ClienteDto> all() {
		try {
			log.info("Buscando Todos Clientes cadastrados");
			List<ClienteDto> every = new ArrayList<ClienteDto>();
			List<ClienteModel> customers = clienteDao.getAll();
			for (ClienteModel customer : customers) {
				every.add(modelMapper.map(customer, ClienteDto.class));
			}
			return every;
		} catch (Exception ex) {
			log.error("Não há Clientes cadastrados !");
			throw ex;
		}
	}

	public ClienteDto searchByCpf(String cpf) {
		try {
			log.info("Buscando Cliente com cpf " + cpf);
			ClienteDto dto = new ClienteDto();
			ClienteModel model = clienteDao.getByCpf(cpf);
			dto = modelMapper.map(model, ClienteDto.class);
			log.info("Nao existe Cliente com cpf " + cpf);
			return dto;
		} catch (Exception ex) {
			log.error("Nenhum Cliente Cadastrado com o cpf " + cpf);
			throw ex;
		}
	}

	public ClienteModel saveClienteDao(ClienteModel cliente) {
		try {
			if (validatingCpf(cliente.getCpf())) {
				log.info("Cadastrando Cliente : " + cliente.getCpf());

				ClienteModel clienteSalvo = clienteDao.save(cliente);
				log.info("Cliente Cadastrado Com Sucesso");
				return clienteSalvo;
			} else {
				log.error("Cpf Inválido : " + cliente.getCpf());
			}
		} catch (Exception ex) {
			log.error("Cliente não cadastrado !");
			throw ex;
		}
		return cliente;
	}

	public ClienteDto change(String cpf, ClienteDto clienteDto) {
		try {
			log.info("Atualizando  Cliente : " + clienteDto.getCpf());
			ClienteModel model = clienteDao.getByCpf(cpf);
			model.setCpf(clienteDto.getCpf());
			model.setEndereco(clienteDto.getEndereco());
			model.setSenha(clienteDto.getSenha());
			model.setData(clienteDto.getData());
			clienteDao.atualizar(model);
			ClienteDto dto = modelMapper.map(model, ClienteDto.class);
			log.info("Cliente atualizado com sucesso");
			return dto;
		} catch (EntityNotFoundException ex) {
			log.error("Cliente não cadastrado !" + cpf);
			throw ex;
		} catch (Exception ex) {
			log.error("Cliente não cadastrado ! " + cpf);
			throw ex;
		}
	}

	public boolean validatingCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void delete(String cpf) {
		try {
			log.info("Removendo Cliente: " + cpf);
			ClienteModel model = clienteDao.getByCpf(cpf);
			clienteDao.delete(model);
			log.info("Remocao concluida com sucesso");
		} catch (Exception ex) {
			log.error("Cliente nao foi removido, cpf nao cadastrado ! " + cpf);
			throw ex;
		}
	}

}
