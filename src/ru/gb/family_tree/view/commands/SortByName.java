package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
