package com.hospitalProject.apiController;

import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patientservice/api/v1/patient")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPatientResponse add(@Valid @RequestBody CreatePatientRequest createPatientRequest) {
        return this.patientService.add(createPatientRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllPatientResponse> getAll() {
        return this.patientService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdPatientResponse getById(@PathVariable UUID id) {
        return this.patientService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedPatientResponse update(@Valid @RequestBody UpdatePatientRequest updatePatientRequest) {
        return this.patientService.update(updatePatientRequest);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable UUID id) {
        this.patientService.delete(id);
    }
}
