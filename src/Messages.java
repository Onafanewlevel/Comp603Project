/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public class Messages {

    public void endMessage(String name, int score) {
        if (score == 1000000) {
            System.out.println(
                    "_________                                             .___      .__            __   .__                         ._.\n"
                    + "\\_   ___ \\   ____    ____    ____ _______ _____     __| _/__ __ |  |  _____  _/  |_ |__|  ____    ____    ______| |\n"
                    + "/    \\  \\/  /  _ \\  /    \\  / ___\\\\_  __ \\\\__  \\   / __ ||  |  \\|  |  \\__  \\ \\   __\\|  | /  _ \\  /    \\  /  ___/| |\n"
                    + "\\     \\____(  <_> )|   |  \\/ /_/  >|  | \\/ / __ \\_/ /_/ ||  |  /|  |__ / __ \\_|  |  |  |(  <_> )|   |  \\ \\___ \\  \\|\n"
                    + " \\______  / \\____/ |___|  /\\___  / |__|   (____  /\\____ ||____/ |____/(____  /|__|  |__| \\____/ |___|  //____  > __\n"
                    + "        \\/              \\//_____/              \\/      \\/                  \\/                        \\/      \\/  \\/"
            );
        } else {
            System.out.println(
                    " __      __         .__   .__    ________                           \n"
                    + "/  \\    /  \\  ____  |  |  |  |   \\______ \\    ____    ____    ____  \n"
                    + "\\   \\/\\/   /_/ __ \\ |  |  |  |    |    |  \\  /  _ \\  /    \\ _/ __ \\ \n"
                    + " \\        / \\  ___/ |  |__|  |__  |    `   \\(  <_> )|   |  \\\\  ___/ \n"
                    + "  \\__/\\  /   \\___  >|____/|____/ /_______  / \\____/ |___|  / \\___  >\n"
                    + "       \\/        \\/                      \\/              \\/      \\/ "
            );
        }
        System.out.println(name + ", you have managed to walk away with $" + score + ".");

    }

    public void banner() {
        System.out.println(
                "         .__ .__   .__   .__                         .__                 \n"
                + "  _____  |__||  |  |  |  |__|  ____    ____  _____   |__|_______   ____  \n"
                + " /     \\ |  ||  |  |  |  |  | /  _ \\  /    \\ \\__  \\  |  |\\_  __ \\_/ __ \\ \n"
                + "|  Y Y  \\|  ||  |__|  |__|  |(  <_> )|   |  \\ / __ \\_|  | |  | \\/\\  ___/ \n"
                + "|__|_|  /|__||____/|____/|__| \\____/ |___|  /(____  /|__| |__|    \\___  >\n"
                + "      \\/                                  \\/      \\/                  \\/"
        );
    }

    public void startBanner() {
        System.out.println(
                "  _________  __                    __  _________ \n"
                + " /   _____/_/  |_ _____  _______ _/  |_\\_____   \\\n"
                + " \\_____  \\ \\   __\\\\__  \\ \\_  __ \\\\   __\\  /   __/\n"
                + " /        \\ |  |   / __ \\_|  | \\/ |  |   |   |   \n"
                + "/_______  / |__|  (____  /|__|    |__|   |___|   \n"
                + "        \\/             \\/                <___>   "
                + "(enter y to begin)"
        );
    }

    public void startBanner2() {
        System.out.println(
                ".____             __           __________                 .__        ._.\n"
                + "|    |     ____ _/  |_  ______ \\______   \\  ____    ____  |__|  ____ | |\n"
                + "|    |   _/ __ \\\\   __\\/  ___/  |    |  _/_/ __ \\  / ___\\ |  | /    \\| |\n"
                + "|    |___\\  ___/ |  |  \\___ \\   |    |   \\\\  ___/ / /_/  >|  ||   |  \\\\|\n"
                + "|_______ \\\\___  >|__| /____  >  |______  / \\___  >\\___  / |__||___|  /__\n"
                + "        \\/    \\/           \\/          \\/      \\//_____/           \\/ \\/"
        );
    }

    public void welcome(String name) {
        System.out.println(
                "\nWelcome " + name + " to \"Who Wants to Be a Millionaire!\""
                + "\n"
                + "Are you ready to test your knowledge and climb the ladder to win the ultimate prize?\n"
                + "You'll face a series of increasingly challenging questions, with each correct answer bringing you closer to the grand million-dollar prize!\n"
                + "\n"
                + "But don’t worry, you're not alone! You have three lifelines to help you along the way:\n\n"
                + "1. 50:50: Removes two incorrect answers, leaving you with one correct and one incorrect answer.\n"
                + "2. Ask for a hint: A hint will be given to you regarding the question.\n"
                + "3. Ask me! I'll give you the answer although you'll have to guess whether I'm bluffing or not!\n\n"
                + "So, are you ready to take a seat in the hot seat and become a millionaire?");
    }
}
