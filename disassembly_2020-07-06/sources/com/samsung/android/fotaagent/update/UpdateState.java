package com.samsung.android.fotaagent.update;

public enum UpdateState {
    NONE,
    INITIALIZE_PULL,
    INITIALIZE_PUSH,
    INITIALIZE_POLLING,
    INITIALIZE_BT_RECONNECT,
    CHECK_CORRECT_CONSUMER,
    EXPIRED_HOLDING_UPDATE_RESULT,
    CONSUMER_CONNECTION_FAILED,
    CHECK_POLLING_INFO,
    POLLING_INFO_CHECK_FAILED,
    NEED_TO_POLLING_UPDATE,
    REPORT_UPDATE_SUCCESS,
    REPORT_UPDATE_FAILURE,
    REPORT_UPDATE_NO_RESPONSE,
    FOTA_REQUEST_COMPLETE
}
