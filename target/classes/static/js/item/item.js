$(function(){
    var itemId=getQueryString("itemId");

    titem(itemId);
})

function titem(itemId) {
    $.ajax({
        url : "/pinyougou/congetitems?itemid="+itemId,
        type : "get",
        dataType : "json",
        success : function(data) {

                itemImgList(data.itemImgs);
                //handleUser(data.user);

        }
    });


}

function itemImgList(data){

  $("#fde").attr("src",data[0].img_type);
  $("#fde").attr("jqimg",data[0].img_fdw);


}
