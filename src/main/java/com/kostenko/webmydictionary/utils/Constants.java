package com.kostenko.webmydictionary.utils;

public final class Constants {
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String MODE = "mode";
    public static final String MODEL_EDIT_FORM = "editForm";
    public static final String ROLE_ADMIN = "ROLE_admin";
    public static final String ROLE_USER = "ROLE_user";

    public final static class View {
        public static final String ADMIN = "AdminView";
        public static final String EDIT_USER = "EditUserView";
        public static final String ERROR = "ErrorView";
        public static final String LOGIN = "LoginView";
        public static final String USER = "UserView";

        public final static class RedirectionTo {
            public static final String ERROR = "redirect:/error";
            public static final String LOGIN = "redirect:" + Path.LOGIN;
            public static final String ADMIN = "redirect:" + Path.ADMIN;
            public static final String USER = "redirect:" + Path.USER;
            public static final String CONGRATULATION = "redirect:" + Path.CONGRATULATION;
        }

        public final static class Path {
            public static final String APP_ROOT = "/";
            public static final String ADMIN = "admin";
            public static final String USER = "user";
            public static final String LOGIN = "log";
            public static final String REGISTRATION = "reg";
            public static final String CONGRATULATION = "congratulation";
        }
    }
}
