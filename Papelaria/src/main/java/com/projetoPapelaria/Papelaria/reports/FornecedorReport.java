package com.projetoPapelaria.Papelaria.reports;

import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.projetoPapelaria.Papelaria.dtos.FornecedorDTO;

public class FornecedorReport {
	
private List<FornecedorDTO> lista;
	
	private static Font FONT_TITULO =
			new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public FornecedorReport(List<FornecedorDTO> lista) {
		this.lista = lista;
	}
	
	public byte[] createPDF() {
		
		try {
			
			Document documento = new Document(PageSize.A4);
			//left, right, top, bottom.
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			/*Image logo = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/animal.png")));
			
			documento.add(logo);*/
			
			Paragraph titulo = new Paragraph();
			Phrase phrase = new Phrase("Relatório de Fornecedores", FONT_TITULO);
			titulo.add(phrase);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			
			documento.add(titulo);
			
			for(FornecedorDTO fornecedorDTO: lista) {
				Paragraph dados = new Paragraph();
				dados.add("Código do Fornecedor: "+fornecedorDTO.getIdFornecedor() + "\n");
				dados.add("Nome do Fornecedor: "+fornecedorDTO.getNomeFornecedor() + "\n");
				dados.add("CNPJ do Fornecedor: "+fornecedorDTO.getCnpjFornecedor() + "\n");
				dados.add("Endereçodo Fornecedor: "+fornecedorDTO.getEnderecoFornecedor() + "\n");
				dados.add("Contato do Fornecedor: "+fornecedorDTO.getContatoFornecedor() + "\n");
				dados.add("Status do Fornecedor: "+fornecedorDTO.getStatusFornecedor() + "\n");
				dados.setSpacingAfter(5);
				documento.add(dados);
			}
						
			documento.close();
			
			return stream.toByteArray();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
