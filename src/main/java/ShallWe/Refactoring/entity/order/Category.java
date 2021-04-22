package ShallWe.Refactoring.entity.order;


public enum Category {
    SHARE, DELIVERY, N_ORDER;

    public static boolean contains(String category){
        for(Enum e : Category.values()){
            if(e.toString().equals(category.toUpperCase()))
                return true;
        }
        return false;
    }
}
