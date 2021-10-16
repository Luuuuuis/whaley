/*
 * Developed by Luis (Luuuuuis @realluuuuuis)
 * Last modified 06.10.21, 19:08
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DefaultController {

    @GetMapping()
    @Cacheable("DEFAULT")
    public String getDefaultRoute() {
        return "Hello from the whaley rest api";
    }

    @GetMapping("/version")
    @Cacheable("DEFAULT_VERSION")
    public String getVersion() {
        return "1.0.0";
    }

}
