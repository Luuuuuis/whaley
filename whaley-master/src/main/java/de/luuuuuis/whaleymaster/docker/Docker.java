/*
 * Developed by Luis (@realluuuuuis)
 * Last modified 16.10.21, 20:48
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import de.luuuuuis.whaleymaster.docker.services.Service;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Docker {

    private final DockerClient dockerClient;
    private final List<Service> serviceList = new ArrayList<>();

    public Docker() {
        DockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost("tcp://localhost:2375")
                //.withDockerHost("unix:///var/run/docker.sock")
//                .withDockerHost("tcp://proxy.luis.team:2376")
//                .withDockerTlsVerify(true)
//                .withDockerCertPath("/home/luis/cloud/cloud/certs/")
                //.withDockerCertPath("C:\\Users\\luist\\IdeaProjects\\MinecraftR6S\\cloud-master\\src\\main\\resources")
                .build();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(clientConfig.getDockerHost())
                .sslConfig(clientConfig.getSSLConfig())
                .build();

        dockerClient = DockerClientImpl.getInstance(clientConfig, httpClient);

        System.out.println("Docker client started");
    }
}
