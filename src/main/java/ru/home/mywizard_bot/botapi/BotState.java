package ru.home.mywizard_bot.botapi;

/**Возможные состояния бота
 */

public enum BotState {
    ASK_DESTINY,
    ASK_NAME,
    ASK_AGE,
    ASK_GENDER,
    ASK_COLOR,
    ASK_NUMBER,
    ASK_MOVIE,
    ASK_SONG,
    FILLING_PROFILE,
    PROFILE_FILLED,
    SHOW_MAIN_MENU,
    SHOW_HELP_MENU;
}
