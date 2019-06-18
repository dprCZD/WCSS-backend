package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.systemType.ShoppingList;
import czd.wcssbackend.persistence.mapper.ShoppingListMapper;
import czd.wcssbackend.web.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ShoppingListServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 17:35
 */
public class ShoppingListServiceImpl implements ShoppingListService {

    @Autowired
    ShoppingListMapper mapper;
    @Override
    public void insertShoppingList(ShoppingList shoppingList) {
        mapper.insertShoppingList(shoppingList);
    }

    @Override
    public void updateShoppingList(ShoppingList shoppingList) {
        mapper.updateShoppingList(shoppingList);
    }

    @Override
    public List<ShoppingList> listShoppingLists() {
        return mapper.listShoppingLists();
    }

    @Override
    public List<ShoppingList> listShoppingListsByParId(Integer parId) {
        return mapper.listShoppingListsByParId(parId);
    }

    @Override
    public void deleteShoppingList(Integer shopId) {
        mapper.deleteShoppingList(shopId);
    }

    @Override
    public ShoppingList getShoppingList(Integer shopId) {
       return mapper.getShoppingList(shopId);
    }
}
