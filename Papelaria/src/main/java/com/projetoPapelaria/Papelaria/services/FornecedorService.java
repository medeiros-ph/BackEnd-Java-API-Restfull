package com.projetoPapelaria.Papelaria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPapelaria.Papelaria.dtos.FornecedorDTO;
import com.projetoPapelaria.Papelaria.entities.Fornecedor;
import com.projetoPapelaria.Papelaria.reports.DadosFornecedorReport;
import com.projetoPapelaria.Papelaria.reports.FornecedorReport;
import com.projetoPapelaria.Papelaria.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public void salvar(FornecedorDTO fornecedorDTO) throws Exception{
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(fornecedorDTO.getIdFornecedor());
		fornecedor.setNome(fornecedorDTO.getNomeFornecedor());
		fornecedor.setCnpj(fornecedorDTO.getCnpjFornecedor());
		fornecedor.setEndereco(fornecedorDTO.getEnderecoFornecedor());
		fornecedor.setContato(fornecedorDTO.getContatoFornecedor());
		fornecedor.setImagem(fornecedorDTO.getImagemFornecedor());
		fornecedor.setStatus(fornecedorDTO.getStatusFornecedor());
		fornecedorRepository.save(fornecedor);		
	}
	
	public List<FornecedorDTO> listarTodos(){	
		List<Fornecedor> lista = fornecedorRepository.findAll();
		List<FornecedorDTO> listaDTO = new ArrayList<>();
		for(Fornecedor fornecedor : lista) {
			FornecedorDTO fornecedorDTO = new FornecedorDTO();
			fornecedorDTO.setIdFornecedor(fornecedor.getId());
			fornecedorDTO.setNomeFornecedor(fornecedor.getNome());
			fornecedorDTO.setCnpjFornecedor(fornecedor.getCnpj());
			fornecedorDTO.setEnderecoFornecedor(fornecedor.getEndereco());
			fornecedorDTO.setContatoFornecedor(fornecedor.getContato());
			fornecedorDTO.setImagemFornecedor(fornecedor.getImagem());
			fornecedorDTO.setStatusFornecedor(fornecedor.getStatus());
			listaDTO.add(fornecedorDTO);
		}
		return listaDTO;
	}
	
	public void excluir(Long id)throws Exception {
    	Fornecedor fornecedor = fornecedorRepository.findById(id).get();
    	if(fornecedor != null) {
    		fornecedorRepository.delete(fornecedor);
    	}
    }
	//Relatorio PDF
    public byte[] gerarRelatorio() {
    	return new FornecedorReport(listarTodos()).createPDF();
    }
    
    public byte[] gerarRelatorio(Long id) {
    	return new DadosFornecedorReport(buscarPorId(id)).createPDF();
    }
	
    public FornecedorDTO buscarPorId (Long id) {
    	Fornecedor fornecedor = fornecedorRepository.findById(id).get();
    	FornecedorDTO fornecedorDTO = new FornecedorDTO();
    	fornecedorDTO.setIdFornecedor(fornecedor.getId());
    	fornecedorDTO.setNomeFornecedor(fornecedor.getNome());
    	fornecedorDTO.setCnpjFornecedor(fornecedor.getCnpj());
    	fornecedorDTO.setEnderecoFornecedor(fornecedor.getEndereco());
    	fornecedorDTO.setContatoFornecedor(fornecedor.getContato());
    	fornecedorDTO.setImagemFornecedor(fornecedor.getImagem());
    	fornecedorDTO.setStatusFornecedor(fornecedor.getStatus());
    	
    	return fornecedorDTO;
    }

}
