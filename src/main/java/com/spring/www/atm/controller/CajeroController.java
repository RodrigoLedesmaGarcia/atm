package com.spring.www.atm.controller;

import com.spring.www.atm.entity.Cajero;
import com.spring.www.atm.service.CajeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/cajero")
public class CajeroController {

    @Autowired
    private CajeroServiceImpl service;

    @GetMapping(value = "/retiro")
    public ResponseEntity<?> retirarEfectivo (@RequestParam("monto") double monto){
        List<Map<String, Object>> lista = service.retirarEfectivo(monto);
        if (lista.isEmpty()){
            Map<String, Object> sinEfectivo = new HashMap<>();
            sinEfectivo.put("sinEfectivo", "sin dinero en el cajero");
            return ResponseEntity.status(HttpStatus.OK).body(sinEfectivo);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }
    }

    @PostMapping(value = "/saldo-disponible")
    public ResponseEntity<?> montoDisponible(){
        return ResponseEntity.status(HttpStatus.OK).body(service.obtenerSaldoDisponible());
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar (){
        List<Cajero> aux = service.listar();
        if (aux.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("sin dinero");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(aux);
        }
    }
} // fin de la clase
