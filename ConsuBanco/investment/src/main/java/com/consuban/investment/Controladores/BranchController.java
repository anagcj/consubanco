package com.consuban.investment.Controladores;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Servicio.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Crear una nueva branch
    @PostMapping("/saveBranch")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {
        Branch savedBranch = branchService.saveBranch(branch);
        return ResponseEntity.ok(savedBranch);
    }

    // Actualizar una branch existente
    @PutMapping("/updateBranch")
    public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch) {
        Branch updatedBranch = branchService.updateBranch(branch);
        return ResponseEntity.ok(updatedBranch);
    }

    // Obtener una branch por su ID
    @GetMapping("/{branchId}")
    public ResponseEntity<Branch> getBranch(@PathVariable int branchId) {
        Optional<Branch> branch = branchService.getBranch(branchId);
        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una branch por su ID
    @DeleteMapping("/{branchId}")
    public ResponseEntity<Void> deleteBranch(@PathVariable int branchId) {
        branchService.deleteBranch(branchId);
        return ResponseEntity.ok().build();
    }

    // Obtener todas las branches
    @GetMapping("/all")
    public ResponseEntity<List<Branch>> getAllBranches() {
        List<Branch> branches = branchService.getAllBranches();
        return ResponseEntity.ok(branches);
    }
}