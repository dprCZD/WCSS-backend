package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.systemType.ShoppingList;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.ShoppingListCreateConfig;
import czd.wcssbackend.web.service.ShoppingListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ShoppingListController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 17:37
 */

@Api(value = "ShoppingListcontroller", description = "购物车操作")
@RestController
@RequestMapping("/api/v1")
public class ShoppingListController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    @Autowired
    ShoppingListService service;

    @ApiOperation(value = "获取购物车", notes = "获取购物车", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "shopId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/shop/{shopId}", method = RequestMethod.GET,produces = "application/json")
    public ShoppingList getShoppingList(@PathVariable("shopId")String shopId){
        int id=-1;
        try{
            id=Integer.valueOf(shopId);
        } catch (NumberFormatException e)
        {

        }
        ShoppingList bean=null;
        if(id!=-1)
            bean=service.getShoppingList(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该购物车信息！").getMessage()); ;
        }
        logger.info("get ShoppingList success:"+shopId);
        return bean;
    }




    @ApiOperation(value = "获取购物车列表", notes = "获取购物车列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parId", value = "", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/shop", method = RequestMethod.GET,produces = "application/json")
    public List<ShoppingList> listShoppingLists(@RequestParam(value = "parId")Integer parId)
    {
        return service.listShoppingListsByParId(parId);
    }



    @ApiOperation(value = "更新购物车", notes = "购物车", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shoppingList", value = "shoppingList", dataType = "ShoppingList", paramType = "body"),
    })
    @RequestMapping(value = "/shop", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateShoppingList(@RequestBody ShoppingList shoppingList)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateShoppingList(shoppingList);
        }
        catch ( Exception e)
        {
            logger.error("update ShoppingList failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_SHOP_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_SHOP_SUCCESS_CODE);
        messageBox.setMessage("update ShoppingList success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "删除购物车", notes = "删除购物车", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "shopId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/shop/{shopId}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteShoppingList(@PathVariable("shopId")Integer shopId)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.deleteShoppingList(shopId);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_SHOP_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_SHOP_SUCCESS_CODE);
        messageBox.setMessage("delete ShoppingList success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入购物车", notes = "插入购物车", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "ShoppingListCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/shop", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertShoppingList(@RequestBody ShoppingListCreateConfig config)
    {
        ShoppingList shoppingList=createShoppingListByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertShoppingList(shoppingList);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_SHOP_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_SHOP_SUCCESS_CODE);
        messageBox.setMessage("insert ShoppingList success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private ShoppingList createShoppingListByConfig(ShoppingListCreateConfig config)
    {
        ShoppingList list=new ShoppingList();
        list.setCourseId(config.getCourseId());
        list.setParId(config.getParId());
        list.setShopNum(config.getShopNum());
        return list;
    }
}
