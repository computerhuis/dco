package com.gitlab.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;

@Slf4j
@SpringBootApplication
public class DcoApplicationStarter {

    private final static String DEFAULT_PROFILE = "otap";

    public static void main(final String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            log.warn("Exception: {}", e.getMessage());
        }

        val application = new SpringApplicationBuilder(DcoApplicationStarter.class)
            .headless(false)
            .profiles(DEFAULT_PROFILE)
            .run(args);

        EventQueue.invokeLater(() -> {
            val tray = application.getBean(DcoApplicationSystemTray.class);
            tray.start();
        });
    }
}
