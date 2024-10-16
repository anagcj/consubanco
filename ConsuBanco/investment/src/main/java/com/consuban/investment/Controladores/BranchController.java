package com.consuban.investment.Controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consuban.investment.DTO.BranchDTO;
import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Servicio.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    // Guardar una nueva sucursal
    @PostMapping("/saveBranch")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {
        Branch savedBranch = branchService.saveBranch(branch);
        return ResponseEntity.ok(savedBranch);
    }

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestParam Long clientId, @RequestBody Branch branch) {
        try {
            Branch createdBranch = branchService.createBranch(clientId, branch);
            return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateBranch")
    public ResponseEntity<BranchDTO> updateBranch(@RequestBody BranchDTO branchDTO) {
        Branch branch = branchService.convertToEntity(branchDTO);
        Branch updatedBranch = branchService.updateBranch(branch);
        return ResponseEntity.ok(branchService.convertToDTO(updatedBranch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable Long id) {
        Optional<Branch> branch = branchService.getBranchById(id);
        return branch.map(value -> ResponseEntity.ok(branchService.convertToDTO(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{branchId}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long branchId) {
        branchService.deleteBranch(branchId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
public List<Branch> getAllBranches() {
    return branchService.getAllBranches();
}
}
