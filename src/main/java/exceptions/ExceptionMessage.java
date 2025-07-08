package exceptions;

public enum ExceptionMessage {
    LOGIN_ERROR("L'utilisateur n'a pas trouvé"),
    USER_NOT_FOUND("ce nom d'utilisateur n'a pas été trouvé"),
    USERDATA_NOT_FOUND("les données de cet utilisateur n'ont pas été trouvé"),
    USER_ALREADY_EXISTS("cet utilisateur existe déjà"),
    INVALID_PASSWORD("Le mot de passe doit contenir au moins une minuscule, " +
            "une majuscule et un caractère spécial (@$!%*#?&) " +
            "et doit faire au moins 10 caractères.");

    private ExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

}
