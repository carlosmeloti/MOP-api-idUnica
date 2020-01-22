package br.embrapa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.repository.MenuEmpresaRepository;

@RestController
@RequestMapping("/menuempresa")
public class MenuEmpresaResource {

	
	@Autowired
	private MenuEmpresaRepository menuEmpresaRepository;
	
}
