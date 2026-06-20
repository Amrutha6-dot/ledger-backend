package com.ledger.ledger_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction updated) {
        updated.setId(id);
        return repository.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}