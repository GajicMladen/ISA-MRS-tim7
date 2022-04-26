package tim7.ISAMRSproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Vikendica;
import tim7.ISAMRSproject.model.VlasnikVikendice;
import tim7.ISAMRSproject.repository.VikendicaRepository;

@Service
public class VikendicaService {

	@Autowired
	private VikendicaRepository vikendicaRepository;
	
	public List<Vikendica> getVikendiceAll(){
		
		return vikendicaRepository.findAll();
	}
	public List<Vikendica> getVikendiceByVlasnik(Long vlasnik){
		
		return vikendicaRepository.findByVlasnikVikendice(vlasnik);
	}
	
	public void addNewCottage(Vikendica vikendica) {
		vikendicaRepository.save(vikendica);
	}
	
}
