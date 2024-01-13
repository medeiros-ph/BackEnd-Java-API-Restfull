package com.projetoPapelaria.Papelaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPapelaria.Papelaria.dtos.FornecedorDTO;
import com.projetoPapelaria.Papelaria.enums.MensagemEnum;
import com.projetoPapelaria.Papelaria.services.FornecedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/fornecedor")
@Tag(name = "Fornecedores", description = "Fornecedores Papelaria API")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/listar")
	@Operation(summary = "", description = "Listar todos os dados dos fornecedores.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	public List<FornecedorDTO> listarTodos(){
		return fornecedorService.listarTodos();
	}	
	
	@PostMapping("/salvar")
	@Operation(summary = "", description = "Salvar os dados do fornecedor.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	public ResponseEntity salva(@RequestBody FornecedorDTO fornecedorDTO) {
		try {
			fornecedorService.salvar(fornecedorDTO);
			return ResponseEntity.ok(MensagemEnum.CADASTRADO.getDescricao());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	}
	
	@PostMapping("/atualizar")
	@Operation(summary = "", description = "Atualizar os dados do animal.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")

	public ResponseEntity atualizar(@RequestBody FornecedorDTO fornecedorDTO) {
	try {
		fornecedorService.salvar(fornecedorDTO);
		return ResponseEntity.ok(MensagemEnum.ATUALIZADO.getDescricao());
	}catch (Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	}
	
	@PostMapping("/excluir/{id}")
	@Operation(summary = "", description = "Excluir dados do fornecedor.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	
	public ResponseEntity excluir(@PathVariable Long id) {
		try {
			fornecedorService.excluir(id);
			return ResponseEntity.ok(MensagemEnum.EXCLUIDO.getDescricao());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	}
	
	@GetMapping("/gerar/relatorio")
	@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
	public ResponseEntity gerarRelatorio() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData(
				"attachment", "fornecedor.pdf");
		return ResponseEntity.ok().headers(headers)
				.body(fornecedorService.gerarRelatorio());
	}
	
	@GetMapping("/gerar/relatorio/{id}")
	@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
	public ResponseEntity gerarRelatorio(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "fornecedor.pdf");
		return ResponseEntity.ok().headers(headers).body(fornecedorService.gerarRelatorio(id));
	}
}
