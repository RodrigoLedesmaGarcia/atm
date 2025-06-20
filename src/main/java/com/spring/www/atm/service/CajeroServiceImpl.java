package com.spring.www.atm.service;

import com.spring.www.atm.entity.Cajero;
import com.spring.www.atm.repository.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CajeroServiceImpl implements  CajeroService{

    @Autowired
    private CajeroRepository repository;

    @Override
    public List<Map<String, Object>> retirarEfectivo(double monto) {
        List<Cajero> cajeroActual = repository.findAll();
        double saldoDisponible = cajeroActual.stream().mapToDouble( c -> c.getCantidad()*c.getDenominaciones()).sum();

        if (monto > saldoDisponible){return  new ArrayList<>();}

        double montoRestante = monto;
        List<Map<String, Object>> resultadoRetiro = new ArrayList<>();
        for (Cajero cajero:cajeroActual){
            int cantidadUtilizada = Math.min(cajero.getCantidad(), (int) (montoRestante / cajero.getDenominaciones()));
            if (cantidadUtilizada > 0){
                Map<String, Object> retirar = new HashMap<>();
                retirar.put("denominacion", cajero.getDenominaciones());
                retirar.put("cantidad", cantidadUtilizada);
                resultadoRetiro.add(retirar);
                montoRestante -= cantidadUtilizada * cajero.getDenominaciones();
            }
            if (montoRestante == 0){break;}
        }

        repository.saveAll(cajeroActual);

        return resultadoRetiro;
    }


    @Override
    public double obtenerSaldoDisponible() {
        return repository.findAll().stream().mapToDouble(c -> c.getCantidad() * c.getDenominaciones()).sum();
    }

    @Override
    public List<Cajero> listar() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
