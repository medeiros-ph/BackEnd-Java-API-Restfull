package com.projetoPapelaria.Papelaria.enums;

public enum MensagemEnum {
	
	CADASTRADO("Fornecedor registrado! Cadastrado com sucesso."),
	ATUALIZADO("Fornecedor registrado e atualizado com sucesso."),
	EXCLUIDO("Fornecedor excluido com sucesso!"),
	NAO_EXISTE_ID_FORNECEDOR("Id do Fornecedor nao existe na base de dados.");
	
	private String descricao;
	
	MensagemEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
