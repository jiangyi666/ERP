

    function page_validate() {//用来检验用户输入的是否合理，指当前的页数和当前页的显示条目数
        var pageTotal=document.forms[0].elements["page_total"].value;
        //alert(pageTotal);
        var pageNo=document.forms[0].elements["pageResult.pageNo"].value;
        if(pageNo<1) pageNo=1;
        if(pageNo>pageTotal) pageNo=pageTotal;
        document.forms[0].elements["pageResult.pageNo"].value=pageNo;
        var pageSize=document.forms[0].elements["pageResult.pageSize"].value;
        if(pageSize<1) pageSize=1;
        document.forms[0].elements["pageResult.pageSize"].value=pageSize;

    }
function page_go() {
    page_validate();
    document.forms[0].submit();
}
function page_first() {
    document.forms[0].elements["pageResult.pageNo"].value=1;
    document.forms[0].submit();
}
function page_pre() {
    var pageNo=document.forms[0].elements["pageResult.pageNo"].value;
    document.forms[0].elements["pageResult.pageNo"].value=parseInt(pageNo)-1;
    page_validate();
    document.forms[0].submit();
}
function page_next() {
    var pageNo=document.forms[0].elements["pageResult.pageNo"].value;
    document.forms[0].elements["pageResult.pageNo"].value=parseInt(pageNo)+1;
    page_validate();
    document.forms[0].submit();
}
function page_last(){
    var pageTotal=document.forms[0].elements["page_total"].value;
    document.forms[0].elements["pageResult.pageNo"].value=pageTotal;
    document.forms[0].submit();
}
