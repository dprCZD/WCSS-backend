package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.systemType.ShoppingList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShoppingListService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 17:34
 */
public interface ShoppingListService {

    void insertShoppingList(ShoppingList shoppingList);

    void updateShoppingList(ShoppingList shoppingList);

    List<ShoppingList> listShoppingLists();

    List<ShoppingList> listShoppingListsByParId(Integer parId);

    void deleteShoppingList(Integer shopId);

    ShoppingList getShoppingList(Integer shopId);
}
