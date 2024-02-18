package com.busRev.controller;


import com.busRev.exception.ReservationException;
import com.busRev.model.Reservation;
import com.busRev.model.ReservationDTO;
import com.busRev.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/busRev/")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("user/reservation/add")
    public ResponseEntity<Reservation> addReservation(@Valid @RequestBody ReservationDTO dto, @RequestParam(required = false) String key) throws ReservationException {
        Reservation reservation = reservationService.addReservation(dto, key);

        return  new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @PutMapping("user/reservation/update/{rid}")
    public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody ReservationDTO dto, @RequestParam(required = false) String key, @PathVariable Integer rid) throws ReservationException{
        Reservation reservation = reservationService.updateReservation(rid, dto, key);

        return  new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping("user/reservation/delete/{rid}")
    public ResponseEntity<Reservation> deleteReservation( @RequestParam(required = false) String key, @PathVariable Integer rid) throws ReservationException{
        Reservation reservation = reservationService.deleteReservation(rid, key);

        return new ResponseEntity<>(reservation, HttpStatus.ACCEPTED);
    }

    @GetMapping("reservation/{rid}")
    public ResponseEntity<Reservation> viewReservationById(@PathVariable Integer rid, @RequestParam(required = false) String key) throws ReservationException {
        Reservation reservation = reservationService.viewReservation(rid, key);
        
        return new ResponseEntity<>(reservation, HttpStatus.FOUND);
    }

    @GetMapping("reservation/all")
    public ResponseEntity<List<Reservation>> viewAllReservation(@RequestParam(required = false) String key) throws ReservationException {
        List<Reservation> reservations = reservationService.getAllReservation(key);

        return new ResponseEntity<>(reservations, HttpStatus.FOUND);
    }

    @GetMapping("user/reservation/{uid}")
    public ResponseEntity<List<Reservation>> viewReservationsByUserId(@PathVariable Integer uid, @RequestParam(required = false) String key) throws ReservationException{
        List<Reservation> reservations = reservationService.viewReservationByUerId(uid, key);

        return  new ResponseEntity<>(reservations, HttpStatus.FOUND);
    }
}
