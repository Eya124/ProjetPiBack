package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.dto.CentreDto;
import tn.esprit.projetpiback.dto.EvenementDto;

import java.util.List;

public interface CentreService {
    public CentreDto createCentre(CentreDto request);
    public List<CentreDto> getAll();
    public CentreDto deleteCentre(int id);
    public CentreDto getById(int id);
    public CentreDto updateCentre(int id, CentreDto request);
    public List<EvenementDto> getEventByCentreId(int id);
}
