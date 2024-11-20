package com.example.parcial.controller;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {
    @Autowired
    private ContratoService service;

    @PostMapping
    public ResponseEntity<ContratoDTO> crear(@RequestBody ContratoDTO contratoDTO) {
        return new ResponseEntity<>(service.crearContrato(contratoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizar(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        return ResponseEntity.ok(service.actualizarContrato(id, contratoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> listar() {
        return ResponseEntity.ok(service.listarContratos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerContratoPorId(id));
    }
}
