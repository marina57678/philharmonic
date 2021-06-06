package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Accs;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccsService {
    List<Accs> accsList();

    Accs saveAccs(Accs newAccs);

    Accs getAccs(@PathVariable long id);//имеет тип  long

    String deleteAccs(@PathVariable long id);
}
