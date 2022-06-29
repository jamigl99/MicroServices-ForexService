/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.forex.forexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.sistemas.forex.forexservice.ExchangeValue;
import pe.edu.unmsm.sistemas.forex.forexservice.ExchangeValueRepository;

/**
 *
 * @author pc
 */
@RestController
public class ForexController {
    @Autowired private Environment env;
    @Autowired private ExchangeValueRepository repo;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue obtenerTipoCambio(@PathVariable String from,
            @PathVariable String to){
        ExchangeValue tc = repo.findByFromAndTo(from, to);
        int iPort = Integer.parseInt(env.getProperty("local.server.port"));
        tc.setPort(iPort);
        return tc;
    }
}
