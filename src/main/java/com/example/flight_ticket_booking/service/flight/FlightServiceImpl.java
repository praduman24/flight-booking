package com.example.flight_ticket_booking.service.flight;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.converter.flight.FlightDtoToFlightConverter;
import com.example.flight_ticket_booking.converter.flight.FlightToFlightDtoConverter;
import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.flight.FlightDto;
import com.example.flight_ticket_booking.dto.flight.FlightFetchRequest;
import com.example.flight_ticket_booking.entity.flight.Flight;
import com.example.flight_ticket_booking.repository.flight.FlightRepository;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {

    private static final Logger LOG = LoggerFactory.getLogger(FlightServiceImpl.class);

    private static final DtoToEntityConverter<FlightDto, Flight> dtoToEntityConverter = new FlightDtoToFlightConverter();

    private static final EntityToDtoConverter<Flight, FlightDto> entityToDtoConverter = new FlightToFlightDtoConverter();

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BaseResponse saveFlight(FlightDto flightDto) {
        BaseResponse response = new BaseResponse();
        Optional<Flight> flightByName = flightRepository.findByNameAndIsActive(flightDto.getName(), true);
        if (flightByName.isPresent()) {
            LOG.info("Flight is already presnt with the given name");
            response.setMessage(Constants.FLIGHT_IS_ALREADY_PRESENT);
            response.setStatus(false);
            return response;
        }

        Flight flight = dtoToEntityConverter.convert(flightDto);
        flight.setCreatedOn(System.currentTimeMillis());
        flight.setCreatedBy(1L);
        flightRepository.save(flight);
        LOG.info("flight is save in db");
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public BaseResponse deleteFlight(Long id) {
        BaseResponse response = new BaseResponse();
        Optional<Flight> flight = flightRepository.findById(id);
        if (!flight.isPresent()) {
            LOG.info("flight is not present in db");
            response.setMessage(Constants.FLIGHT_IS_NOT_PRESENT);
            response.setStatus(false);
            return response;
        }

        flight.get().setActive(false);
        flight.get().setModifiedBy(1L);
        flight.get().setModifiedOn(System.currentTimeMillis());
        flightRepository.save(flight.get());
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public BaseResponse updateFlight(FlightDto flightDto) {
        BaseResponse response = new BaseResponse();
        Optional<Flight> flight = flightRepository.findById(flightDto.getId());
        if (!flight.isPresent()) {
            LOG.info("flight is not present in db");
            response.setMessage(Constants.FLIGHT_IS_NOT_PRESENT);
            response.setStatus(false);
            return response;
        }
        Flight flightObj = dtoToEntityConverter.convert(flightDto);
        flightObj.setModifiedOn(System.currentTimeMillis());
        flightObj.setModifiedBy(1L);
        flightRepository.save(flightObj);
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public List<FlightDto> getAllFlight(FlightFetchRequest flightFetchRequest) {

        if(flightFetchRequest.getStartTime() != null & flightFetchRequest.getEndTime() != null){
            return flightRepository.findAllByFlightTimeBetweenAndIsActiveTrue(flightFetchRequest.getStartTime(),flightFetchRequest.getEndTime()).stream().map(entityToDtoConverter::convert).collect(Collectors.toList());
        }else if(flightFetchRequest.getActive() != null && !flightFetchRequest.getActive()){
            return flightRepository.findAllByIsActiveFalse().stream().map(entityToDtoConverter::convert).collect(Collectors.toList());
        }else{
            return flightRepository.findAllByIsActiveTrue().stream().map(entityToDtoConverter::convert).collect(Collectors.toList());
        }
    }
}
