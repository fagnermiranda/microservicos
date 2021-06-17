package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.dto.CompraDTO;
import br.com.microservice.loja.dto.InfoFornedorDTO;
import br.com.microservice.loja.dto.InfoPedidoDTO;
import br.com.microservice.loja.model.Compra;

@Service
public class CompraService {
    
	@Autowired
	private FornecedorClient fornecedorClient; 	
   
	public Compra realizaCompra(CompraDTO compra) {
		InfoFornedorDTO fornecedor = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

		System.out.println(fornecedor.getEndereco());
		
		Compra compraRealizada = new Compra();
		compraRealizada.setPedidoId(pedido.getId());
		compraRealizada.setTempoPreparo(pedido.getTempoDePreparo());
		compraRealizada.setEnderecoDestino(compra.getEndereco().toString()); 
		return compraRealizada;
	}

}
