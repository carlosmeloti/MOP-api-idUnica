package br.embrapa.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.event.RecursoCriadoEvent;
import br.embrapa.model.MenuEmpresa;
import br.embrapa.repository.MenuEmpresaRepository;
import br.embrapa.repository.filter.MenuEmpresaFilter;
import br.embrapa.service.MenuEmpresaService;

@RestController
@RequestMapping("/menuempresa")
public class MenuEmpresaResource {

	
	@Autowired
	private MenuEmpresaRepository menuEmpresaRepository;
	
	@Autowired
	private MenuEmpresaService menuEmpresaService;
	
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public Page<MenuEmpresa> pesquisar(MenuEmpresaFilter menuEmpresaFilter, Pageable pageable){
		return menuEmpresaRepository.filtrar(menuEmpresaFilter, pageable);
	}
	
	/*
	 * @GetMapping("/empresaselecionada")
	 * 
	 * @PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')"
	 * ) public List<MenuEmpresa> recuperarEmpresSelecionada(){
	 * 
	 * MenuEmpresa m = new MenuEmpresa();
	 * 
	 * m.
	 * 
	 * 
	 * return menuEmpresaRepository.recuperarEmpresSelecionada(); }
	 */
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<MenuEmpresa> criar(@RequestBody MenuEmpresa menuEmpresa, HttpServletResponse response) {
		MenuEmpresa menuEmpresaSalva = menuEmpresaRepository.save(menuEmpresa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, menuEmpresaSalva.getCdEmpresa()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(menuEmpresaSalva);
	}
	
	@GetMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public ResponseEntity <MenuEmpresa>buscarPeloCodigo(@PathVariable Long cdEmpresa) {
		MenuEmpresa menuEmpresa = menuEmpresaRepository.findOne(cdEmpresa);
		return menuEmpresa != null ? ResponseEntity.ok(menuEmpresa) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_EMPRESA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdEmpresa) {
		menuEmpresaRepository.delete(cdEmpresa);
	}
	
	@PutMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<MenuEmpresa> atualizar(@PathVariable Long cdEmpresa, @Valid @RequestBody MenuEmpresa menuEmpresa) {
		MenuEmpresa menuEmpresaSalva = menuEmpresaService.atualizar(cdEmpresa, menuEmpresa);
		return ResponseEntity.ok(menuEmpresaSalva);
	}
	

}
