package List;

/**
 * Created by Administrator on 2019/9/25.
 */
public interface MyList {
    public void add(int value);
    public int remove(int index) throws Exception;
    public void update(int index,int value) throws Exception;
    public int get(int index) throws Exception;
    public int size();
}
