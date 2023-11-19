package io.github.vatisteve.notitool.fcm;

import io.github.vatisteve.notitool.design.application.TopicManagementResponse;

/**
 * @author vatisteve
 * @since 0.1.0
 */
public record FcmTopicResponse(int successCount, int failureCount) implements TopicManagementResponse {}
