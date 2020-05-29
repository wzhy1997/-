package com.wzhy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
        prefix = "app"
)
public class AppConfig {

        private String uploadFolder;
        private String previewPath;

        public AppConfig() {
        }

        public String getUploadFolder() {
            return this.uploadFolder;
        }

        public void setUploadFolder(String uploadFolder) {
            this.uploadFolder = uploadFolder;
        }

        public String getPreviewPath() {
            return this.previewPath;
        }

        public void setPreviewPath(String previewPath) {
            this.previewPath = previewPath;
        }
    }

