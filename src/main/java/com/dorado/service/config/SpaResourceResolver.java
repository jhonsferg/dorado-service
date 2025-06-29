package com.dorado.service.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class SpaResourceResolver implements ResourceResolver {

    private final Resource index = new ClassPathResource("static/index.html");
    private final List<String> handledExtensions = List.of("html", "js", "json", "csv", "css", "png", "svg", "eot", "ttf", "woff", "appcache", "jpg", "jpeg", "gif", "ico");
    private final List<String> ignoredPaths = List.of("api");

    @Override
    public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
        if (isIgnored(requestPath)) {
            return null;
        }

        Resource resolved = chain.resolveResource(request, requestPath, locations);
        if (resolved != null) {
            return resolved;
        }

        if (isNotExtension(requestPath)) {
            return index;
        }

        return null;
    }

    @Override
    public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
        Resource resolvedResource = chain.resolveResource(null, resourcePath, locations);
        if (resolvedResource != null) {
            try {
                return resolvedResource.getURL().toString();
            } catch (IOException e) {
                return resourcePath;
            }
        }
        return null;
    }

    private boolean isIgnored(String path) {
        return ignoredPaths.stream().anyMatch(path::startsWith);
    }

    private boolean isNotExtension(String path) {
        return handledExtensions.stream().noneMatch(path::contains);
    }
}
