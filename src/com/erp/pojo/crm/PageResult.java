package com.erp.pojo.crm;

import java.util.ArrayList;
import java.util.List;

/**
     * @Author: JiangYi
     * @Date: 2018/9/24 20:20
     * @Description:分页的分装类
     */
    public class PageResult {
        private int pageNo=1;//实际页号
        private int pageSize=6;//每页记录数
        private int recTotal=0;//总记录数
        private List list=new ArrayList();//查询结果

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getRecTotal() {
            return recTotal;
        }

        public void setRecTotal(int recTotal) {
            this.recTotal = recTotal;
        }

        public List getList() {
            return list;
        }

        public void setList(List list) {
            this.list = list;
        }
        public int getPageTotal(){
            //根据记录数计算总的页数
            int ret=(this.getRecTotal()-1)/this.getPageSize()+1;
            ret=(ret<1)?1:ret;
            return  ret;
        }
        public int getFirstRec(){
            int ret=(this.getPageNo()-1)*this.getPageSize();
            ret=(ret<1)?0:ret;
            return ret;
        }
}
