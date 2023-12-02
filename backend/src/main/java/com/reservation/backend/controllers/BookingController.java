package com.reservation.backend.controllers;

import com.reservation.backend.dto.BookingDTO;
import com.reservation.backend.dto.PaginatedResponseDTO;
import com.reservation.backend.dto.search.BookingSearchDTO;
import com.reservation.backend.services.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
@CrossOrigin
@Slf4j
@Validated
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        log.info("REST request to get Booking {}", id);
        BookingDTO foundBooking = this.bookingService.findBookingById(id);
        return ResponseEntity.ok().body(foundBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable Long id) {
        log.info("REST request to cancel Booking {}", id);
        BookingDTO deletedBooking = this.bookingService.deleteBooking(id);
        return ResponseEntity.ok().body(deletedBooking);
    }

    @GetMapping
    public ResponseEntity<PaginatedResponseDTO<BookingDTO>> getAllUserBookings(
            BookingSearchDTO bookingSearchDTO) {
        log.info("REST request to get all user Bookings");
        PaginatedResponseDTO<BookingDTO> paginatedResponse = this.bookingService.findAllUserBookings(bookingSearchDTO);
        return ResponseEntity.ok().body(paginatedResponse);
    }


}
