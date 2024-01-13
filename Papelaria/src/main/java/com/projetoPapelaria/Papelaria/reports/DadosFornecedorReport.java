package com.projetoPapelaria.Papelaria.reports;

import java.io.ByteArrayOutputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.projetoPapelaria.Papelaria.dtos.FornecedorDTO;

public class DadosFornecedorReport {
	
	private FornecedorDTO fornecedorDTO;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public DadosFornecedorReport(FornecedorDTO fornecedorDTO) {
		this.fornecedorDTO = fornecedorDTO;
	}

	public byte[] createPDF() {
		
		try {
			
			//Construtor
			Document documento = new Document(PageSize.A4);
			//left, right, top, bottom.
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image imagem = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/"+fornecedorDTO.getImagemFornecedor())));
			imagem.setAlignment(Element.ALIGN_CENTER);
			
			documento.add(imagem);
			
				Paragraph dados = new Paragraph();
				dados.add("Código: "+fornecedorDTO.getIdFornecedor() + "\n");
				dados.add("Nome: "+fornecedorDTO.getNomeFornecedor() + "\n");
				dados.add("CNPJ/CPF: "+fornecedorDTO.getCnpjFornecedor() + "\n");
				dados.add("Endereço: "+fornecedorDTO.getEnderecoFornecedor() + "\n");
				dados.add("Contato: "+fornecedorDTO.getContatoFornecedor() + "\n");
				dados.add("Status: "+fornecedorDTO.getStatusFornecedor() + "\n");
				dados.setSpacingAfter(5);
				documento.add(dados);
				
			documento.close();
			
			return stream.toByteArray();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
