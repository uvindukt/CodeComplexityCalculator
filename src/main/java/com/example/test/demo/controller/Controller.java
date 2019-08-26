package com.example.test.demo.controller;

import com.example.test.demo.service.*;
import com.example.test.demo.util.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class Controller {

    private FileStorageService fileStorageService;

    @Autowired
    public Controller(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public @ResponseBody
    ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {

        HashMap<String, Object> response = new HashMap<>();

        try {

            String fileName = fileStorageService.storeFile(file);

            response.put("message", "File uploaded successfully.");
            response.put("uri", new FileStorageProperties().getUploadDir() + "\\" + fileName);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/cs")
    public @ResponseBody
    ResponseEntity getCs(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Cs csService = new Cs(list);
            response.put("CS", csService.getCs());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/ctc")
    public @ResponseBody
    ResponseEntity getCtc(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Ctc ctcService = new Ctc(list);
            response.put("CTC", ctcService.getCtc());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/cnc")
    public @ResponseBody
    ResponseEntity getCnc(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Cnc cncService = new Cnc(list);
            response.put("CNC", cncService.getCnc());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/ci")
    public @ResponseBody
    ResponseEntity getCi(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Ci ciService = new Ci(list);
            response.put("CI", ciService.getCi());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/cps")
    public @ResponseBody
    ResponseEntity getCps(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Cs csService = new Cs(list);
            Ctc ctcService = new Ctc(list);
            Cnc cncService = new Cnc(list);
            Ci ciService = new Ci(list);
            Tw twService = new Tw(list, ctcService.getCtc(), cncService.getCnc(), ciService.getCi());
            Cps cpsService = new Cps(list, csService.getCs(), twService.getTw());
            response.put("CPS", cpsService.getCps());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/tw")
    public @ResponseBody
    ResponseEntity getTw(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Ctc ctcService = new Ctc(list);
            Cnc cncService = new Cnc(list);
            Ci ciService = new Ci(list);
            Tw twService = new Tw(list, ctcService.getCtc(), cncService.getCnc(), ciService.getCi());
            response.put("TW", twService.getTw());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/cr")
    public @ResponseBody
    ResponseEntity getCr(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            Cnc cncService = new Cnc(list);
            Ci ciService = new Ci(list);
            Cs csService = new Cs(list);
            Ctc ctcService = new Ctc(list);
            Tw twService = new Tw(list, ctcService.getCtc(), cncService.getCnc(), ciService.getCi());
            Cps cpsService = new Cps(list, csService.getCs(), twService.getTw());
            Cr crService = new Cr(list, cpsService.getCps());
            response.put("CR", crService.getCr());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}