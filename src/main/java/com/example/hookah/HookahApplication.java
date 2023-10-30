package com.example.hookah;

import com.example.hookah.frame.Frame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class HookahApplication extends Frame {

    public HookahApplication() {
        super();
    }

    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(HookahApplication.class)
                .headless(false).web(WebApplicationType.NONE).run(args);

        EventQueue.invokeLater(() -> {
            var ex = ctx.getBean(HookahApplication.class);
            ex.setVisible(true);
        });
    }

}
