package com.api.employee.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.api.employee.Entity.Employee;
import com.api.employee.Models.AuthenticationRequest;
import com.api.employee.Models.AuthenticationResponse;
import com.api.employee.Services.MyUserDetailsService;
import com.api.employee.Util.jwtUtil;
import com.api.employee.dao.EmployeeRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepo db;

    @Autowired
    private MyUserDetailsService myUserdetailservice;

    @Autowired
    private jwtUtil jwtTokenUtil;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(HttpServletRequest request) {

        List<Employee> employees = (List<Employee>) db.findAll();
        employees.forEach(employee -> {
            System.out.println(employee);
        });
        return employees;
    }

    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee, HttpServletRequest request) {

        /* For logging date */
        String userAgent = request.getHeader("user-agent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String hitTime = dtf.format(now);
        logger.info("hit-time " + hitTime);

        /* For logging browser details */
        logger.info("Client-info " + userAgent);

        /* Logging IP address of client */
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        logger.info(remoteAddr);

        // Saving in JPA repo
        Employee emp = db.save(employee);
        return emp;
    }

    @PostMapping("/addemployees")
    public List<Employee> addEmployees(@RequestBody Employee[] employee, HttpServletRequest request) {
        /* For logging date */
        String userAgent = request.getHeader("user-agent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String hitTime = dtf.format(now);
        logger.info("hit-time " + hitTime);

        /* For logging browser details */
        logger.info("Client-info " + userAgent);

        List<Employee> itrEmpList = List.of(employee);
        // Saving in JPA repo
        itrEmpList = (List<Employee>) db.saveAll(itrEmpList);

        return itrEmpList;
    }

    // to implement logging of IP address
    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id, HttpServletRequest request) {
        /* For logging date */
        String userAgent = request.getHeader("user-agent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String hitTime = dtf.format(now);
        logger.info("hit-time " + hitTime);

        /* For logging browser details */
        logger.info("Client-info " + userAgent);

        // deleting from JPA repo
        db.deleteById(id);

    }

    @DeleteMapping("/deleteall")
    public void deleteAll(HttpServletRequest request) {
        /* For logging date */
        String userAgent = request.getHeader("user-agent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String hitTime = dtf.format(now);
        logger.info("hit-time " + hitTime);

        /* For logging browser details */
        logger.info("Client-info " + userAgent);

        // deleting from JPA repo
        db.deleteAll();

    }

    @PutMapping("update-employee")
    public Employee updateEmployee(@RequestBody Employee emp, @RequestBody int id, HttpServletRequest request) {
        /* For logging date */
        String userAgent = request.getHeader("user-agent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String hitTime = dtf.format(now);
        logger.info("hit-time " + hitTime);

        /* For logging browser details */
        logger.info("Client-info " + userAgent);

        emp.setId(id);
        // saving in JPA repo
        db.save(emp);

        return emp;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUserName(), authReq.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username password", e);
        }
        final UserDetails userDetails = myUserdetailservice.loadUserByUsername(authReq.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
