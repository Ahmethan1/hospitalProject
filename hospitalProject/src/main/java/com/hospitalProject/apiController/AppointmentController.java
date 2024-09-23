package com.hospitalProject.apiController;

import com.hospitalProject.business.abstracts.AppointmentService;
import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointmentservice/api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAppoinmentResponse add(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest) {
        return this.appointmentService.add(createAppointmentRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAppointmentResponse> getAll() {
        return this.appointmentService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdAppointmentResponse getById(@PathVariable UUID id) {
        return this.appointmentService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedAppointmentResponse update(@Valid @RequestBody UpdateAppointmentRequest updateAppointmentRequest) {
        return this.appointmentService.update(updateAppointmentRequest);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable UUID id) {
        this.appointmentService.delete(id);
    }
}
