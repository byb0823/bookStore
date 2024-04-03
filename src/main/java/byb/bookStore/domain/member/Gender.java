package byb.bookStore.domain.member;

public enum Gender {

    M("남자"), W("여자");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
