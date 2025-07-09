package exceptions;

public enum ExceptionMessage {
    LOGIN_ERROR("L'utilisateur n'a pas été trouvé"),
    MULTIPLE_USERS_FOUND("Une erreur est survenue plusieurs utilisateurs ont été trouvé"),
    USER_NOT_FOUND("ce nom d'utilisateur n'a pas été trouvé"),
    USERDATA_NOT_FOUND("les données de cet utilisateur n'ont pas été trouvé"),
    USER_ALREADY_EXISTS("cet utilisateur existe déjà"),
    INVALID_USERNAME("Le nom d'utilisateur est invalide"),
    INVALID_PASSWORD("Le mot de passe doit contenir au moins une minuscule, " +
            "une majuscule et un caractère spécial (@$!%*#?&) " +
            "et doit faire au moins 10 caractères."),
    INVALID_INPUT_INTEGER("Le nombre entré est invalide : veuillez entrer un entier"),
    INVALID_INPUT_FLOAT("Le nombre entré est invalide : veuillez entrer un nombre entier ou décimal"),
    INVALID_INPUT("Le champs est invalide"),
    INVALID_INPUTS("Un ou plusieurs champs sont invalides"),
    INVALID_FILTER("Le filtre appliqué n'est pas reconnu"),
    STUDENT_NOT_SELECTED("Vous n'avez pas sélectionné d'étudiant");

    private ExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

}
