package com.java.web_travel.controller.admin;

import com.java.web_travel.entity.Flight;
import com.java.web_travel.model.request.FlightDTO;
import com.java.web_travel.model.response.ApiReponse;
import com.java.web_travel.service.FlightService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@Slf4j
public class FLightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/create")
    public ApiReponse<Flight> createFlight(@Valid @RequestBody FlightDTO flightDTO) {
        log.info("Create flightDTO: {}", flightDTO);
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        Flight flight = flightService.createFlight(flightDTO);
        apiReponse.setData(flight);
        apiReponse.setMessage("Flight created");
        log.info("Flight created successfully: {}", flight);
        return apiReponse;
    }
    @DeleteMapping("/delete/{id}")
    public ApiReponse<Flight> deleteFlight(@PathVariable Long id) {
        log.info("Delete flight id = : {}", id);
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        flightService.deleteFlight(id);
        apiReponse.setMessage("Flight deleted");
        log.info("Flight deleted successfully id = : {}", id);
        return apiReponse;
    }
    @PatchMapping("/update/{id}")
    public ApiReponse<Flight> updateFlight(@PathVariable Long id,@Valid @RequestBody FlightDTO flightDTO) {
        log.info("Update flight id = {}", id);
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        apiReponse.setData(flightService.updateFlight(id, flightDTO));
        apiReponse.setMessage("Flight updated");
        log.info("Flight updated successfully id = {}", id);
        return apiReponse;
    }
    @GetMapping("/getAll")
    public ApiReponse<List<Flight>> getAllFlights() {
        log.info("Get all flights");
        ApiReponse<List<Flight>> apiReponse = new ApiReponse<>();
        apiReponse.setData(flightService.getAllFlights());
        apiReponse.setMessage("success");
        log.info("Get all success");
        return apiReponse;
    }
}
