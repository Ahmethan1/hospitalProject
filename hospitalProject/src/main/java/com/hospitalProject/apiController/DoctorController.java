package com.hospitalProject.apiController;

import com.hospitalProject.business.abstracts.DoctorService;
import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.CreatedDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetAllDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetByIdDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.UpdatedDoctorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public CreatedDoctorResponse add(@Valid @RequestBody CreateDoctorRequest createDoctorRequest){
        return this.doctorService.add(createDoctorRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllDoctorResponse> getAll(){
        return this.doctorService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdDoctorResponse getById(@PathVariable UUID id){
        return this.doctorService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedDoctorResponse update(@Valid @RequestBody UpdateDoctorRequest updateDoctorRequest){
        return this.doctorService.update(updateDoctorRequest);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable UUID id){
        this.doctorService.delete(id);
    }
}
