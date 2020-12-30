package apap.ta.sipayroll.controller;


import apap.ta.sipayroll.model.UserModel;
import apap.ta.sipayroll.service.RekruitmenRestService;
import apap.ta.sipayroll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RekruitmenController{
    @Autowired
    private RekruitmenRestService rekruitmenRestService;

    @Autowired
    private UserService userService;

    @GetMapping("/addLowongan")
    private String addLowongan(){
        return "form-nambah-rekruitmen";
    }
    @RequestMapping(value="/add-rekruitmen", method = RequestMethod.POST)

    private String addLowonganSubmit(String divisi, String posisi, String jumlah_karyawan, String jenis, Model model){

        model.addAttribute("text", "Request Lowongan Berhasil ditambahkan");

        if(divisi != null && posisi != null && jumlah_karyawan != null) {
            rekruitmenRestService.postRek(divisi, posisi, jumlah_karyawan, jenis);
        }
        return "add-lowongan";
    }

}
