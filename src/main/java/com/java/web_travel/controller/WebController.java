package com.java.web_travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/login")
    public String login() {return "user";}
    @GetMapping("/user")
    public String userPage() {
        return "user";
    }
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    @GetMapping("/booking")
    public String bookingPage() {
        return "booking";
    }
    @GetMapping("/hotel")
    public String hotelPage() {
        return "hotel";
    }
    @GetMapping("/trending")
    public String trendingPage() {
        return "trending";
    }
    @GetMapping("/news")
    public String newsPage() {
        return "news";
    }
    @GetMapping("/package")
    public String packagePage() {
        return "package";
    }
    @GetMapping("/services")
    public String servicesPage() {
        return "services";
    }
    @GetMapping("/gallery")
    public String galleryPage() {
        return "gallery";
    }
    @GetMapping("/review")
    public String reviewPage() {
        return "review";
    }
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @GetMapping("/plan-trip")
    public String planTripPage() {
        return "plan-trip";
    }
    @GetMapping("/flight")
    public String flightPage() {
        return "flight";
    }
    @GetMapping("/admin_booking")
    public String adminBookingPage() {
        return "admin_booking";
    }
    @GetMapping("/admin_account")
    public String adminAccountPage() {
        return "admin_account";
    }
    @GetMapping("/admin_flights")
    public String adminFlightsPage() {return "admin_flights";}
    @GetMapping("/admin_hotel")
    public String adminHotelPage() {return "admin_hotel";}
    @GetMapping("/profile")
    public String profilePage() {return "profile";}
    @GetMapping("/newPass")
    public String newPassPage() {return "changePassWord";}
}
