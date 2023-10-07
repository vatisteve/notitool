package io.github.vatisteve.fcm;

import io.github.vatisteve.design.application.TopicManagementResponse;

public record FcmTopicResponse(int successCount, int failureCount) implements TopicManagementResponse {}
