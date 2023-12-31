package io.github.vatisteve.notitool.fcm;

import io.github.vatisteve.notitool.design.application.MessageManagementResponse;

/**
 * @author vatisteve
 * @since 0.1.0
 */
public class FcmMessageResponse implements MessageManagementResponse {

    private final boolean batch;
    private final String messageId;
    private final int successCount;
    private final int failureCount;

    public FcmMessageResponse() {
        this.batch = false;
        this.messageId = null;
        this.successCount = 0;
        this.failureCount = 0;
    }

    public FcmMessageResponse(String messageId) {
        this.batch = false;
        this.messageId = messageId;
        this.successCount = 1;
        this.failureCount = 0;
    }

    public FcmMessageResponse(int successCount, int failureCount) {
        this.batch = true;
        this.messageId = null;
        this.successCount = successCount;
        this.failureCount = failureCount;
    }

    /**
     * @return is batch message or not
     */
    public boolean isBatch() {
        return batch;
    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @return the successCount
     */
    public int getSuccessCount() {
        return successCount;
    }

    /**
     * @return the failureCount
     */
    public int getFailureCount() {
        return failureCount;
    }

}
