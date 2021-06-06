package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Declare;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DeclareService {
    List<Declare> declareList();

    Declare saveDeclare(Declare newDeclare);
    Declare getDeclare(@PathVariable long id); //имеет тип  long
    String deleteDeclare(@PathVariable long id);

    // Declare updateDeclare(@PathVariable long id, Declare declare);
}