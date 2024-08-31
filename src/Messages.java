
/**
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
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
        } else if (score == 0) {
            System.out.println(
                    ".____       _____      _____   ________          _________                           \n"
                    + "|    |     /     \\    /  _  \\  \\_____  \\        /   _____/ __________________ ___.__.\n"
                    + "|    |    /  \\ /  \\  /  /_\\  \\  /   |   \\       \\_____  \\ /  _ \\_  __ \\_  __ <   |  |\n"
                    + "|    |___/    Y    \\/    |    \\/    |    \\      /        (  <_> )  | \\/|  | \\/\\___  |\n"
                    + "|_______ \\____|__  /\\____|__  /\\_______  / /\\  /_______  /\\____/|__|   |__|   / ____|\n"
                    + "        \\/       \\/         \\/         \\/  )/          \\/                     \\/     "
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
                "\n"
                + "         .__ .__   .__   .__                         .__                 \n"
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

    public void timesUp() {
        System.out.println(
                "\n"
                + "___________.__             /\\          ____ ___       ._.\n"
                + "\\__    ___/|__| _____   ___)/  ______ |    |   \\______| |\n"
                + "  |    |   |  |/     \\_/ __ \\ /  ___/ |    |   /\\____ \\ |\n"
                + "  |    |   |  |  Y Y  \\  ___/ \\___ \\  |    |  / |  |_> >|\n"
                + "  |____|   |__|__|_|  /\\___  >____  > |______/  |   __/__\n"
                + "                    \\/     \\/     \\/            |__|   \\/\n"
                + "Im sorry but your time is up! Press any button to continue..."
        );
    }

    public void welcome(String name) {
        System.out.println(
                "\nWelcome " + name + " to \"Who Wants to Be a Millionaire!\""
                + "\n"
                + "Are you ready to test your knowledge and climb the ladder to win the ultimate prize?\n"
                + "You'll face a series of increasingly challenging questions, with each correct answer"
                + "\nbringing you closer to the grand million-dollar prize!\n"
                + "\n"
                + "But don’t worry, you're not alone! You have two lifelines to help you along the way:\n\n"
                + "1. 50:50: Removes two incorrect answers, leaving you with one correct and one incorrect answer.\n"
                + "2. Ask for a hint: A hint will be given to you regarding the question.\n\n"
                + "So, are you ready to take a seat in the hot seat and become a millionaire?");
    }
}
