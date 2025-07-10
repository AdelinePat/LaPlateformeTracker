package exceptions;

public enum ExceptionMessage {
    LOGIN_ERROR("Le nom d'utilisateur ou mot de passe est incorrect."),
    HASH_ERROR("Une erreur est survenue"),
    REGISTER_ERROR("L'utilisateur n'a pas pu être créé"),
    MULTIPLE_USERS_FOUND("Une erreur est survenue plusieurs utilisateurs ont été trouvé"),
    USER_NOT_FOUND("L'utilisateur n'a pas été trouvé"),
    USERDATA_NOT_FOUND("Les données de cet utilisateur n'ont pas été trouvé"),
    USER_ALREADY_EXISTS("Cet utilisateur existe déjà"),
    INVALID_USERNAME("Le nom d'utilisateur est invalide"),
    INVALID_PASSWORD("Le mot de passe doit contenir au moins une minuscule, " +
            "une majuscule et un caractère spécial (@$!%*#?&) " +
            "et doit faire au moins 10 caractères."),
    INVALID_INPUT_INTEGER("Le nombre entré est invalide : veuillez entrer un entier"),
    INVALID_INPUT_FLOAT("Le nombre entré est invalide : veuillez entrer un nombre entier ou décimal"),
    INVALID_INPUT("Le champs est invalide"),
    INVALID_INPUTS("Un ou plusieurs champs sont invalides"),
    INVALID_FILTER("Le filtre appliqué n'est pas reconnu"),
    NO_RESULT("Aucun résultat n'a été trouvé avec ce filtre"),
    SQL_ERROR("Une erreur est survenue"),
    SQL_FORMAT_ERROR("Le format n'est pas convertible en format numérique"),
    STUDENT_NOT_SELECTED("Vous n'avez pas sélectionné d'étudiant"),
    EXPORT_ERROR("Une erreur d'export est survenue");

    private ExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

}
