package ShallWe.Refactoring.entity.partyMember;

import ShallWe.Refactoring.entity.order.Category;

public enum PartyStatus {
    WAITING("WAITING"), JOIN("JOIN"), CANCEL("CANCEL");

    private final String name;

    PartyStatus(String name){
        this.name = name;
    }

    public static PartyStatus getPartyStatus(String string) {
        for(PartyStatus partyStatus : PartyStatus.values()) {
            if(partyStatus.name.equals(string)) {
                return partyStatus;
            }
        }
        throw new RuntimeException();
    }
}

