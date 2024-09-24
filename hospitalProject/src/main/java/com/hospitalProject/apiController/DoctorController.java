package com.hospitalProject.apiController;

import com.hospitalProject.business.abstracts.DoctorService;
import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.LoginDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctorservice/api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedDoctorResponse add(@Valid @RequestBody CreateDoctorRequest createDoctorRequest) {
        return this.doctorService.add(createDoctorRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<GetAllDoctorResponse> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page,size);
        return this.doctorService.getAll(pageable);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdDoctorResponse getById(@PathVariable UUID id) {
        return this.doctorService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedDoctorResponse update(@Valid @RequestBody UpdateDoctorRequest updateDoctorRequest) {
        return this.doctorService.update(updateDoctorRequest);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable UUID id) {
        this.doctorService.delete(id);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LoginDoctorResponse login(@RequestBody LoginDoctorRequest loginDoctorRequest){
        return this.doctorService.login(loginDoctorRequest);
    }
}
