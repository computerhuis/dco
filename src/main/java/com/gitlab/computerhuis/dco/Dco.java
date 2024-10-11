package com.gitlab.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;

@Slf4j
@SpringBootApplication
public class Dco {

    private final static String DEFAULT_PROFILE = "otap";

    public static void main(final String[] args) {

        val headless = GraphicsEnvironment.isHeadless();
        val application = new SpringApplicationBuilder(Dco.class)
            .headless(headless)
            .profiles(DEFAULT_PROFILE)
            .run(args);

        if (!headless && SystemTray.isSupported()) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                log.warn("Exception: {}", e.getMessage());
            }

            EventQueue.invokeLater(() -> {
                val tray = application.getBean(DcoSystemTray.class);
                tray.start();
            });
        }
    }
}
