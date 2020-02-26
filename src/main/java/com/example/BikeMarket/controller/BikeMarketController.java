package com.example.BikeMarket.controller;


import com.example.BikeMarket.database.DataBaseAction;
import com.example.BikeMarket.model.Skuter;
import com.example.BikeMarket.storage.AmazonStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.BikeMarket.database.DataBaseAction.readFromDataBase;

@Controller
public class BikeMarketController {
    public static String uploadDirectory = System.getProperty("user.dir")+"\\upload";

    @GetMapping(value = "/")
    public String mainPage(Model model){
        readFromDataBase();
        model.addAttribute("skuters", Skuter.getAllSkuters());
        return "index";
    }

    @GetMapping(value = "/addbike")
    public String addScuter(Model model){
        model.addAttribute("skuter", new Skuter());
        return "addBike";
    }

    @PostMapping(value = "/addbike")
    public String saveScuter(@ModelAttribute Skuter skuter, @RequestParam("file")MultipartFile file){
        String nameFile;
        nameFile = file.getOriginalFilename();
        byte[] imgaeBytes=null;
        try {
            imgaeBytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = AmazonStorage.sendPhoto(nameFile,imgaeBytes);
        skuter.setImageUrl(url);
        skuter.setIdBike();
        DataBaseAction.sendBike(skuter);
        return "redirect:/";
    }


    @GetMapping(value = "/edit")
    public String editBike(Model model){
        readFromDataBase();
        model.addAttribute("skuters", Skuter.getAllSkuters());
        model.addAttribute("skuter", new Skuter());
        return "edit";
    }


    @PostMapping(value = "/edit")
    public String upDateBike(@ModelAttribute Skuter skuter, @RequestParam("file")MultipartFile file){

        String nameFile;
        nameFile = file.getOriginalFilename();
        if(!nameFile.equals("")){

            byte[] imgaeBytes=null;
            try {
                imgaeBytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String url = AmazonStorage.sendPhoto(nameFile,imgaeBytes);
            skuter.setImageUrl(url);
        }
        DataBaseAction.upDateBike(skuter);
        return "redirect:/";
    }


}
