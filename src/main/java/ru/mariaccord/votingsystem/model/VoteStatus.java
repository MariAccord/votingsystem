package ru.mariaccord.votingsystem.model;

public enum VoteStatus {
    SUCCESSFULL("Голос учтён!"),
    LATE("Голосование не может быть изменено после 11:00"),
    REVOTE("Голосование успешно изменено");
    private String value;

    public String getValue() {
        return value;
    }

    VoteStatus(String value) {
        this.value = value;
    }
}
