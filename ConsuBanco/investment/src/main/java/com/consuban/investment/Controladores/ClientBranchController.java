package com.consuban.investment.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consuban.investment.Objetos.ClientHasBranch;
import com.consuban.investment.Servicio.ClientHasBranchService;

@RestController
@RequestMapping("/client-branch")
public class ClientBranchController {

    @Autowired
    private ClientHasBranchService clientHasBranchService;

    @PostMapping("/assign")
    public ResponseEntity<ClientHasBranch> assignClientToBranch(@RequestParam Long clientId, @RequestParam Long branchId) {
        ClientHasBranch clientHasBranch = clientHasBranchService.saveClientBranchRelation(clientId, branchId);
        return ResponseEntity.ok(clientHasBranch);
    }
    
}