/*
 * Developed by Luis (@realluuuuuis)
 * Last modified 16.10.21, 20:48
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster;

import de.luuuuuis.whaleymaster.docker.Docker;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.luuuuuis.whaleymaster.rest"})
public class WhaleyMasterApplication {

    @Getter
    private static Docker docker;

    public WhaleyMasterApplication() {
        docker = new Docker();
    }

    public static void main(String[] args) {
        // start Spring server
        SpringApplication.run(WhaleyMasterApplication.class, args);

        new WhaleyMasterApplication();
    }

}
