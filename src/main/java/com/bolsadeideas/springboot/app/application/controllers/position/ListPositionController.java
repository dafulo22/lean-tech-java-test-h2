package com.bolsadeideas.springboot.app.application.controllers.position;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.POSITION_URL;

import com.bolsadeideas.springboot.app.business.company.interfaces.PositionService;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(POSITION_URL)
public class ListPositionController {

    private final PositionService positionService;

    public ListPositionController(
        PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Position>> findAll() {
        return ResponseEntity.ok().body(this.positionService.findAll());
    }
}