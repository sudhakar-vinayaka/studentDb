package io.sudhakar.student.controller;

import io.sudhakar.student.dto.Employee;
import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.StudentResponse;
import io.sudhakar.student.service.impl.RestTemplateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employee")
public class RestTemplateController {
    private final RestTemplateServiceImpl restTemplateService;

    public RestTemplateController(RestTemplateServiceImpl restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping
    public ResponseEntity<StudentResponse<?>> getAllEmployee(@RequestParam("urlName") String urlName) {

        log.info("api = /employee, method = GET, status = IN_PROCESS");

        ServiceResponse<?> serviceResponse = restTemplateService.getAllEmployee(urlName);

        log.info("api = /employee, method = GET, status = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).body(new StudentResponse<>(serviceResponse.getData()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse<?>> getEmployeeById(@RequestParam("urlName") String urlName, @PathVariable int id) {

        log.info("api = /employee, method = GET, status = IN_PROCESS");

        ServiceResponse<?> serviceResponse = restTemplateService.getEmployeeById(urlName,id);

        log.info("api = /employee, method = GET, status = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).body(new StudentResponse<>(serviceResponse.getData()));
    }

    @PostMapping
    public ResponseEntity<StudentResponse<?>> addEmployee(@RequestParam("urlName") String urlName,@RequestBody Employee employee) {

        log.info("api = /employee, method = POST, status = IN_PROCESS");

        ServiceResponse<?> serviceResponse = restTemplateService.addEmployee(urlName,employee);

        log.info("api = /employee, method = POST, status = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse<?>> updateEmployee(@RequestParam("urlName") String urlName,@RequestBody Employee employee,@PathVariable int id) {

        log.info("api = /employee, method = PUT, status = IN_PROCESS");

        ServiceResponse<?> serviceResponse = restTemplateService.updateEmployee(urlName,employee,id);

        log.info("api = /employee, method = PUT, status = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentResponse<?>> deleteEmployee(@RequestParam("urlName") String urlName,@PathVariable int id) {

        log.info("api = /employee, method = DELETE, status = IN_PROCESS");

        ServiceResponse<?> serviceResponse = restTemplateService.deleteEmployee(urlName,id);

        log.info("api = /employee, method = DELETE, status = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

}