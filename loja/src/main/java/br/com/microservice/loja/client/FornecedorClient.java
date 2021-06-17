package br.com.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.microservice.loja.dto.InfoFornedorDTO;
import br.com.microservice.loja.dto.InfoPedidoDTO;
import br.com.microservice.loja.dto.ItemCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornedorDTO getInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedido")
	InfoPedidoDTO  realizaPedido(List<ItemCompraDTO> itens);
}
