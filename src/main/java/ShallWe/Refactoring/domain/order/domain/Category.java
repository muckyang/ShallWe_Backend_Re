package ShallWe.Refactoring.domain.order.domain;


public enum Category {
    SHARE("share"), DELIVERY("delivery"), N_ORDER("n_order");
    private String name;

    Category(String name) {
        this.name = name;
    }

    public static boolean contains(String category) {
        for (Enum e : Category.values()) {
            if (e.toString().equals(category.toUpperCase()))
                return true;
        }
        return false;
    }
    public static Category getCategory(String string) {
        for(Category category : Category.values()) {
            if(category.name.equals(string)) {
                return category;
            }
        }
        throw new RuntimeException();
    }


}
