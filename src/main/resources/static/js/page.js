/**
 * Created by zxm on 2017/3/31.
 */
$.fn.extend({
    "initPage":function(listCount,currentPage,totalPage,fun,pageSize,maxshowpageitem){
        if(pageSize && pageSize > 0){
            page.pagelistcount = parseInt(pageSize);
        }
        if(maxshowpageitem && maxshowpageitem > 0){
            page.maxshowpageitem = parseInt(maxshowpageitem);
        }
        /*var maxshowpageitem = $(this).attr("maxshowpageitem");
        if(maxshowpageitem!=null&&maxshowpageitem>0&&maxshowpageitem!=""){
            page.maxshowpageitem = maxshowpageitem;
        }*/
        /*var pagelistcount = $(this).attr("pagelistcount");
        if(pagelistcount!=null&&pagelistcount>0&&pagelistcount!=""){
            page.pagelistcount = pagelistcount;
        }*/
        var pageId = $(this).attr("id");
        page.pageId=pageId;
        if(listCount<0){
            listCount = 0;
        }
        if(currentPage<=0){
            currentPage=1;
        }
        page.setPageListCount(pageId,listCount,currentPage,totalPage,fun);

    }
});
var  page = {
    "maxshowpageitem":5,//最多显示的页码个数
    "pagelistcount":10,//每一页显示的内容条数
    /**
     * 初始化分页界面
     * @param listCount 列表总量
     */
    "initWithUl":function(pageId,listCount,currentPage,totalPage){

        var pageCount = 1;
        if(listCount>0){
            var pageCount = listCount%page.pagelistcount>0?parseInt(listCount/page.pagelistcount)+1:parseInt(listCount/page.pagelistcount);
        }
        var appendStr = page.getPageListModel(pageCount,currentPage,totalPage);
        $("#" + pageId).html(appendStr);
    },
    /**
     * 设置列表总量和当前页码
     * @param listCount 列表总量
     * @param currentPage 当前页码
     */
    "setPageListCount":function(pageId,listCount,currentPage,totalPage,fun){
        listCount = parseInt(listCount);
        currentPage = parseInt(currentPage);
        totalPage = parseInt(totalPage);
        page.initWithUl(pageId,listCount,currentPage,totalPage);
        page.initPageEvent(pageId,listCount,totalPage,fun);

    },
    "initPageEvent":function(pageId,listCount,totalPage,fun){
        $("#"+pageId +">li[class='pageItem']").unbind().on("click",function(){
            if(typeof fun == "function"){
                fun($(this).attr("page-data"));
                page.setPageListCount(pageId,listCount,$(this).attr("page-data"),totalPage,fun);
            }
        });
        $("#jumpPageButton").unbind().on("click",function (e) {
            var goPage = $("input#jumpPageInput").val();
            if(goPage && parseInt(goPage) > 0 && parseInt(goPage) <= totalPage) {
                if (typeof fun == "function") {
                    fun(parseInt(goPage));
                }
                page.setPageListCount(pageId,listCount,parseInt(goPage),totalPage,fun);
            }
        })
    },
    "getPageListModel":function(pageCount,currentPage,totalPage){
        var prePage = currentPage-1;
        var nextPage = currentPage+1;
        var prePageClass ="pageItem";
        var nextPageClass = "pageItem";
        if(prePage<=0){
            prePageClass="pageItemDisable";
        }
        if(nextPage>pageCount){
            nextPageClass="pageItemDisable";
        }
        var appendStr ="";
        //appendStr+="<li class='"+prePageClass+"' page-data='1' page-rel='firstpage'>首页</li>";
        appendStr+="<li style='line-height: 20px' class='"+prePageClass+"' page-data='"+prePage+"' page-rel='prepage'>&lt;</li>";
        var miniPageNumber = 1;
        if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)<=pageCount){
            miniPageNumber = currentPage-parseInt(page.maxshowpageitem/2);
        }else if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)>pageCount){
            miniPageNumber = pageCount-page.maxshowpageitem+1;
            if(miniPageNumber<=0){
                miniPageNumber=1;
            }
        }
        var showPageNum = parseInt(page.maxshowpageitem);
        if(pageCount<showPageNum){
            showPageNum = pageCount
        }
        for(var i=0;i<showPageNum;i++){
            var pageNumber = miniPageNumber++;
            var itemPageClass = "pageItem";
            if(pageNumber==currentPage){
                itemPageClass = "pageItemActive";
            }

            appendStr+="<li class='"+itemPageClass+"' page-data='"+pageNumber+"' page-rel='itempage'>"+pageNumber+"</li>";
        }
        appendStr+="<li style='line-height: 20px' class='"+nextPageClass+"' page-data='"+nextPage+"' page-rel='nextpage'>&gt;</li>";
        appendStr+="<li><span id='totalPageSpan' data-total='"+totalPage+"'>共"+totalPage+"页</span></li>";
        appendStr+="<li><span>到</span><span><input type='number' id='jumpPageInput' /></span><span>页</span></li>";
        appendStr+="<li><a href='javascript:void(0)' id='jumpPageButton' class='blue block'>跳转</a></li>";
        //appendStr+="<li class='"+nextPageClass+"' page-data='"+pageCount+"' page-rel='lastpage'>尾页</li>";
       return appendStr;

    }
}