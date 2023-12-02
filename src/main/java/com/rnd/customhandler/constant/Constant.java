package com.rnd.customhandler.constant;

public class Constant {

    public static class Regex {
        public static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9 ]+$";
        public static final String NUMERIC_PATTERN = "\\d+";

    }

    public static class ResponseMessage {
        public static final String SUCCESS_MESSAGE = "Success";
        public static final String INVALID_REQUEST = "Invalid field format {value}";
    }

    public static class ResponseCode {
        public static final int SUCCESS_CODE = 200;
        public static final int BAD_REQUEST_CODE = 400;
    }
}
