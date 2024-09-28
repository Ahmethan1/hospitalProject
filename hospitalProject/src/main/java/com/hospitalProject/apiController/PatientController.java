package com.hospitalProject.apiController;

import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.LoginPatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patientservice/api/v1/patient")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPatientResponse add(@Valid @RequestBody CreatePatientRequest createPatientRequest) {
        return this.patientService.add(createPatientRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<GetAllPatientResponse> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.patientService.getAll(pageable);
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
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        this.patientService.delete(id);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LoginPatientResponse login(@RequestBody LoginPatientRequest loginPatientRequest){
        return this.patientService.login(loginPatientRequest);
    }


}
