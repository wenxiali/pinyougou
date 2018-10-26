$(function () {
    var cart="";
    shoppingList();

})

function shoppingList(){
    var tophtml="";

    $.get("http://localhost:8080/pinyougou/shoppingList","",function(data){
        var shoppingCart=data.shoppingCart;

        $.each(shoppingCart,function(key,values) {
            /*alert(values.sellertitle);*/
            tophtml+="<div class=\"cart-item-list\">\n" +
                "\t\t\t\t\t<div class=\"cart-shop\">\n" +
                "\t\t\t\t\t\t<input type=\"checkbox\" name=\"\" class='itembox' value='1' />\n" +
                "\t\t\t\t\t\t<span class=\"shopname\">"+values.sellertitle+"</span>\n" +
                "\t\t\t\t\t</div>"+
                 "<div class=\"cart-body\">";
            var shopingList=values.shoppingList;
            $.each(shopingList,function (key,values) {
                /*alert(values.itemtitle);*/
             tophtml+="<div class=\"cart-list\">\n" +
                 "\t\t\t\t\t\t\t<ul class=\"goods-list yui3-g\">\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-1-24\">\n" +
                 "\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"\" class='itemclick' shoppingId="+values.shoppingid+" value="+values.itemClick+" />\n" +
                 "\t\t\t\t\t\t\t\t</li>\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-11-24\">\n" +
                 "\t\t\t\t\t\t\t\t\t<div class=\"good-item\">\n" +
                 "\t\t\t\t\t\t\t\t\t\t<div class=\"item-img\"><img style='width: 50px; height: 50px;' src="+values.itemImg+"/></div>\n" +
                 "\t\t\t\t\t\t\t\t\t\t<div class=\"item-msg\">"+values.itemtitle+
                 "</div>\n" +
                 "\t\t\t\t\t\t\t\t\t</div>\n" +
                 "\t\t\t\t\t\t\t\t</li>\n" +
                 "\t\t\t\t\t\t\t\t\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-1-8\"><span class=\"price\">"+values.itemPrice+"</span></li>\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-1-8\">\n" +
                 "\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class='increment mins jian'>-</a>\n" +
                 "\t\t\t\t\t\t\t\t\t<input autocomplete=\"off\" type=\"text\" value='"+values.itemQuantity+"' minnum=\"1\" class=\"itxt\" />\n" +
                 "\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class='increment mins jia'>+</a>\n" +
                 "\t\t\t\t\t\t\t\t</li>\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-1-8\"><span class=\"sum \">"+values.amount+"</span></li>\n" +
                 "\t\t\t\t\t\t\t\t<li class=\"yui3-u-1-8\">\n" +
                 "\t\t\t\t\t\t\t\t\t<a class='scna' href=\"#none\">删除</a><br />\n" +
                 "\t\t\t\t\t\t\t\t\t<a href=\"#none\">移到我的关注</a>\n" +
                 "\t\t\t\t\t\t\t\t</li>\n" +
                 "\t\t\t\t\t\t\t</ul>\n" +
                 "\t\t\t\t\t\t</div>";

            });
            tophtml+="</div></div>";

            $(".cart-main").append(tophtml);
            tophtml="";
        });

        clickbox(false);
        updateclick();
        cliene();
        serrleclick();
        clickCount();
        shoppingamount();
        jiaquantity();
        jianquantity();
    },"json")

}

function clickbox(boole){
    var boole=false;
    $(".cart-item-list").each(function(i){

        $(this).find(".itemclick").each(function(){
            var click=$(this).val();
            if(click==1){
                boole=true;
                $(this).attr("checked",'true');
            }else {
                boole=false;
                return false;
            }

        })
        if(boole){
            $(this).find(".itembox").attr("checked",'true');
        }
    })
    if(boole){

        $(".chqunabu").prop("checked",true);
    }else {

        $(".chqunabu").prop("checked",false);
    }
}


function updateclick(){
    var boole=false;
    var boote=false;
    $(".itemclick").click(function(){
       $(this).parents(".cart-main").find(".itemclick").each(function(){
            if($(this).is(':checked')) {
                boote=true;
            }else {
                boote=false;
                return false;
            }

        });
        if(boote){
            $(".chqunabu").prop("checked",true);
        }else {
            $(".chqunabu").prop("checked",false);
        }

        $(this).parents(".cart-item-list").find(".itemclick").each(function(){
            if($(this).is(':checked')) {
               boole=true;
            }else {
                boole=false;
                return false;
            }
        });
        if(boole==true){

            $(this).parents(".cart-item-list").find(".itembox").prop("checked",true);

        }else {

            $(this).parents(".cart-item-list").find(".itembox").prop("checked",false);

        }
        queryList();
    })



}
//全选或不选
function cliene(){
    $(".chqunabu").on("click",function () {
        var boole=false;
        if($(this).is(':checked')){
            boole=true;
        }else {
            boole=false;
        }

        if(boole){
            $("input:checkbox").prop("checked",true);

        }else {
            $("input:checkbox").prop("checked",false);

        }
        queryList();
    })
}
function serrleclick() {
    var boole=false;
    var boote=true;
    $(".itembox").click(function () {

        $(this).parents(".cart-main").find(".itembox").each(function(){
            if($(this).is(':checked')) {
                boote=true;
            }else {
                boote=false;
                return false;
            }

        });
        if(boote){
            $(".chqunabu").prop("checked",true);
        }else {
            $(".chqunabu").prop("checked",false);
        }

        if($(this).is(':checked')){
          boole=true;
        }else {
          boole=false;
        }
        $(this).parents(".cart-shop").siblings(".cart-body").find(".itemclick").each(function () {
            if(boole){
                $(this).prop("checked",true);
            }else {
                $(this).prop("checked",false);
            }
        })
        queryList();
    })



}

//查询全部按钮
function queryList(){
    var trueShoppingIds=new Array();
    var falseShoppingIds=new Array();
    $(".cart-main").find(".itemclick").each(function(){

        if($(this).is(':checked')) {
            trueShoppingIds.push($(this).attr("shoppingId"));
        }else {
            falseShoppingIds.push($(this).attr("shoppingId"));
        }
    })
    $.ajax({
        type : "post",
        url : "/pinyougou/trueshoppings",
        traditional: true,
        data :{
            "trueShoppingIds" : trueShoppingIds,
            "falseShoppingIds":falseShoppingIds
        },
        dataType : "json",
        success : function(data) {
                  clickCount();
                  shoppingamount();
        }

    });


}

function jiaquantity() {
    $(".jia").click(function () {
        var quantity=$(this).parents(".cart-list").find(".itxt");
        var sum=$(this).parents(".cart-list").find(".sum");
        var shoppingId=$(this).parents(".cart-list").find(".itemclick").attr("shoppingId");
        $.ajax({
            type : "get",
            url : "/pinyougou/jiaquantity",
            traditional: true,
            data :{
                "quantity" : quantity.val(),
                "shoppingId":shoppingId
            },
            dataType : "json",
            success : function(data) {
               if(data.seccuss){
                   quantity.val( parseInt(quantity.val())+1);
                  priceQuantCount(shoppingId,sum);
               }else {
                   alert(data.errMsg);

               }

                shoppingamount();

            }
        })

    })
}

function jianquantity() {
    $(".jian").click(function () {
        var quantity=$(this).parents(".cart-list").find(".itxt");
        var sum=$(this).parents(".cart-list").find(".sum");
        var shoppingId=$(this).parents(".cart-list").find(".itemclick").attr("shoppingId");
        $.ajax({
            type : "get",
            url : "/pinyougou/jianquantity",
            traditional: true,
            data :{
                "quantity" : quantity.val(),
                "shoppingId":shoppingId
            },
            dataType : "json",
            success : function(data) {
                if(data.seccuss){
                    quantity.val( parseInt(quantity.val())-1);
                    priceQuantCount(shoppingId,sum);
                }else {
                    alert(data.errMsg);

                }

                shoppingamount();

            }
        })

    })
}

function priceQuantCount(shoppingId,sum){
    $.ajax({
        type : "get",
        url : "/pinyougou/pricequantCount",

        data :{
            "shoppingId":shoppingId
        },
        traditional: true,
        dataType : "json",
        success : function(data) {
            if(data.success){
               sum.text(data.aumqat);
            }
        }
    })
}


function clickCount(){
    $.ajax({
        type : "get",
        url : "/pinyougou/clickcount",

        dataType : "json",
        success : function(data) {
            if(data.success){
                $("#cjieur").text(data.count);
            }else {
                $("#cjieur").text("0");
            }
        }
    })
}

/**
 * 获取选中商品的总金额
 */
function shoppingamount(){
    $.get("/pinyougou/shoppingamount","",function (data) {

        if(data.shopinngAmount!=null){
            $(".summoney").text("¥"+data.shopinngAmount);
        }else {
            $(".summoney").text("¥0.00");
        }
    })
}

