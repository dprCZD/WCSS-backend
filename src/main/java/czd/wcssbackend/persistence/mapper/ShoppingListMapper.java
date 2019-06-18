package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.systemType.ShoppingList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShoppingListMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 16:49
 */
@Mapper
public interface ShoppingListMapper {

    void insertShoppingList(@Param("shoppingList")ShoppingList shoppingList);

    void updateShoppingList(@Param("shoppingList")ShoppingList shoppingList);

    List<ShoppingList> listShoppingLists();

    List<ShoppingList> listShoppingListsByParId(@Param("parId")Integer parId);

    void deleteShoppingList(@Param("shopId")Integer shopId);

    ShoppingList getShoppingList(@Param("shopId")Integer shopId);


}
