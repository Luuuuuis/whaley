/*
 * Developed by Luis (Luuuuuis @realluuuuuis)
 * Last modified 06.10.21, 19:28
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.controllers.docker;

import de.luuuuuis.whaleymaster.WhaleyMasterApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class DockerController {

    @GetMapping()
    @Cacheable("DOCKER")
    public String getAbout() {
        return WhaleyMasterApplication.getDocker().getDockerClient().infoCmd().exec().toString();
    }

    @GetMapping("/version")
    @Cacheable("DOCKER_VERSION")
    public String getVersion() {
        return WhaleyMasterApplication.getDocker().getDockerClient().versionCmd().exec().getVersion();
    }

}
