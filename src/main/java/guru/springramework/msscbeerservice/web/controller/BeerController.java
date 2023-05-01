package guru.springramework.msscbeerservice.web.controller;

import guru.springramework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("{id}")
    public ResponseEntity<BeerDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BeerDto beer) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody BeerDto beer) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
