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

}
