package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.DAO.AccountDAO;
import com.dangdao.shop.entities.Account;
import com.dangdao.shop.service.AccountService;
import com.dangdao.shop.service.impl.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAdmin {

    @Autowired
    SessionService session;
    @Autowired
    AccountDAO dao;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/admin/login")
    public String Login(){
        return "/views/admin/login";
    }

    @PostMapping("/admin/login")
    public String login(Model model, @RequestParam("user") String user, @RequestParam("password") String password) {
        HttpSession session = request.getSession();
        Account entity = dao.FindByUserName(user);
        if (entity == null) {
            model.addAttribute("message","Sai UserName!");
            return "/views/admin/login";
        }
        if(entity.getPassword().equals(password)){
            session.setAttribute("account", entity);
            return "redirect:/admin/dashboard";
        }else{
            model.addAttribute("message","Sai Password!");
            return "/views/admin/login";
        }
    }

    @RequestMapping("/admin/logout")
    public String logout(Model model) {
        session.remove("account");
        model.addAttribute("message","Logout Thành Công!");
        return "/views/admin/login";
    }

}
