package com.example.test.demo.controller;

import com.example.test.demo.model.Line;
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
import java.util.List;
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
            response.put("url", new FileStorageProperties().getUploadDir() + "\\" + fileName);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/cs")
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

            s.close();

            Cs csService = new Cs(list);
            response.put("CS", csService.getCs());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/ctc")
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

            s.close();

            Ctc ctcService = new Ctc(list);
            response.put("CTC", ctcService.getCtc());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/cnc")
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

            s.close();

            Cnc cncService = new Cnc(list);
            response.put("CNC", cncService.getCnc());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/ci")
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

            s.close();

            Ci ciService = new Ci(list);
            response.put("CI", ciService.getCi());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/cps")
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

            s.close();

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

    @PostMapping("/tw")
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

            s.close();

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

    @PostMapping("/cr")
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

            s.close();

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

    @PostMapping("/cc")
    public @ResponseBody
    ResponseEntity getCC(@RequestBody HashMap<String, String> request) {

        HashMap<String, Object> response = new HashMap<>();
        Scanner s;
        ArrayList<String> list = new ArrayList<>();

        try {

            s = new Scanner(new File(request.get("url")));

            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }

            s.close();

            ArrayList<Integer> ctc, cnc, cs, ci, cps, tw, cr;

            Cnc cncService = new Cnc(list);
            cnc = cncService.getCnc();

            Ci ciService = new Ci(list);
            ci = ciService.getCi();

            Cs csService = new Cs(list);
            cs = csService.getCs();

            Ctc ctcService = new Ctc(list);
            ctc = ctcService.getCtc();

            Tw twService = new Tw(list, ctc, cnc, ci);
            tw = twService.getTw();

            Cps cpsService = new Cps(list, cs, tw);
            cps = cpsService.getCps();

            Cr crService = new Cr(list, cps);
            cr = crService.getCr();

            List<Line> cc = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                Line line = new Line(i, list.get(i), cs.get(i), ctc.get(i), cnc.get(i), ci.get(i), tw.get(i), cps.get(i), cr.get(i));
                cc.add(line);
            }

            return new ResponseEntity<>(cc, HttpStatus.OK);

        } catch (Exception e) {

            e.printStackTrace();
            response.put("message", "Something went wrong.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}