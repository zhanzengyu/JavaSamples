package zzy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Collections {
    /**
     * Get random element from list except selfE
     * @param list input list for random
     * @param selfE input element which is except
     * @return element from list excpet selfE
     * @param <E> type
     */
    public static <E> E randomElementExceptSelf(List<E> list, E selfE) {
        if (list == null || list.isEmpty() || selfE == null) {
            return null;
        }

        List<E> copyList = new ArrayList<>(list);
        copyList.removeIf(selfE::equals);

        int size = copyList.size();
        if (size == 0) {
            return null;
        }

        return copyList.get(ThreadLocalRandom.current().nextInt(size));
    }
}
