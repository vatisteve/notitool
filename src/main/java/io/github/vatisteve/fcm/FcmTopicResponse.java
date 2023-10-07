package io.github.vatisteve.fcm;

import io.github.vatisteve.design.application.TopicManagementResponse;

/**
 * @author vatisteve
 * @since 0.1.0
 */
public record FcmTopicResponse(int successCount, int failureCount) implements TopicManagementResponse {}
