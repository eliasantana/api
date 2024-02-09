package br.com.escola.api.services;

import br.com.escola.api.dto.CadEscolaDto;
import br.com.escola.api.model.CadEscola;
import br.com.escola.api.repository.CadEscolaRepository;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CadEscolaServices {
    @Autowired
    CadEscolaRepository repository;

    public ResponseEntity<CadEscolaDto> createCadEscola(CadEscolaDto dto) {
        CadEscola cadastro = new CadEscola(dto);
        CadEscola cadEscola = repository.save(cadastro);
        CadEscolaDto cadEscolaDto = new CadEscolaDto(cadEscola);
        return new ResponseEntity<>(cadEscolaDto, HttpStatus.CREATED);
    }

    public ResponseEntity<List<CadEscolaDto>> listar() {
        List<CadEscola> listCadEscola = repository.listar();
        List<CadEscolaDto> listDto = listCadEscola.stream()
                .map(cadEscola -> new CadEscolaDto(cadEscola))
                .collect(Collectors.toList());
      return  ResponseEntity.ok(listDto);
    }

    public Optional<CadEscola> localizar(Long id) {
        return repository.findById(id);
    }

    public ResponseEntity<CadEscolaDto> alterar(Long id, CadEscolaDto dto) {
        Optional<CadEscola> cadEscola = localizar(id);
        if (cadEscola.isPresent()){
            dto.setCdEscola(cadEscola.get().getCdEscola());
            CadEscola cadastroSalvo = repository.save(new CadEscola(dto));
            return ResponseEntity.ok(new CadEscolaDto(cadastroSalvo));
        }else{
           throw new NotFoundException("Cadastro não localizado!");
        }
    }
}
