package utils;

public class APIJsonData {
    public static String login(String username, String password) {
        return "{\n" +
                "  \"email\": \"" + username + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";
    }

    public static String resetPassword(String username) {
        return "{\n" +
                "  \"email\": \"" + username + "\"\n" +
                "}";
    }

    public static String createAnnouncement(String text, String groupID) {
        return "{\n" +
                "  \"text\": \"" + text + "\",\n" +
                "  \"groupId\": " + groupID + "\n" +
                "}";
    }

    public static String createStudent(String name, String lastName, String phone, String email, String groupId, String studyFormat) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"phoneNumber\": \"" + phone + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"groupId\": " + 1 + ",\n" +
                "  \"studyFormat\": \"" + studyFormat + "\"\n" +
                "}";
    }

    public static String addTeacher(String name, String lastName, String phone, String email, String specialization, String courses) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"phoneNumber\": \"" + phone + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"specialization\": \"" + specialization + "\",\n" +
                "  \"courses\": [\n" +
                "    " + courses + "\n" +
                "  ]\n" +
                "}";
    }

    public static String updateTeacher(String name, String lastName, String phone, String email, String specialization, String courses) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"phoneNumber\": \"" + phone + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"specialization\": \"" + specialization + "\",\n" +
                "  \"courses\": [\n" +
                "    " + courses + "\n" +
                "  ]\n" +
                "}";
    }


}
