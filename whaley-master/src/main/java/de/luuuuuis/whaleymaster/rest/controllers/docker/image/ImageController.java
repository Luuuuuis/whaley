/*
 * Developed by Luis (Luuuuuis @realluuuuuis)
 * Last modified 16.10.21, 19:12
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.controllers.docker.image;

import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.command.PullImageResultCallback;
import de.luuuuuis.whaleymaster.WhaleyMasterApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/docker/image")
public class ImageController {

    @GetMapping()
    public InspectImageResponse getImage(@RequestBody String image) {
        return WhaleyMasterApplication.getDocker().getDockerClient().inspectImageCmd(image).exec();
    }

    @GetMapping("/all")
    public Object[] getAllImages() {
        return WhaleyMasterApplication.getDocker().getDockerClient().listImagesCmd().withShowAll(true).exec().toArray();
    }

    @PostMapping()
    public boolean pullImage(@RequestBody String image) throws InterruptedException {
        PullImageResultCallback pullImageResultCallback = WhaleyMasterApplication.getDocker().getDockerClient().pullImageCmd(image).exec(new PullImageResultCallback());

        return pullImageResultCallback.awaitCompletion(1, TimeUnit.MINUTES);
    }
}
