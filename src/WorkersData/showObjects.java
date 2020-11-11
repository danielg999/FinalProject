package WorkersData;

import java.util.List;

public class showObjects<T> {
    public void printList(List<T> list)
    {
        for (T m : list)
        {
            System.out.println(m.toString());
        }
    }
}
