package com.ding.biz.mybatis.page;
/**
* <p>Title: Paginable.java</p>  
* <p>package: com.ding.biz.mybatis.page</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月3日  
* @version 1.0
 */
public interface Paginable {


		/**
		 * 总记录数
		 * 
		 * @return
		 */
		public int getTotalCount();

		/**
		 * 总页数
		 * 
		 * @return
		 */
		public int getTotalPage();

		/**
		 * 每页记录数
		 * 
		 * @return
		 */
		public int getPageSize();

		/**
		 * 当前页号
		 * 
		 * @return
		 */
		public int getPageNo();

		/**
		 * 是否第一页
		 *
		 * @return
		 */
		public boolean isFirstPage();

		/**
		 * 是否最后一页
		 * 
		 * @return
		 */
		public boolean isLastPage();

		/**
		 * 返回下页的页号
		 */
		public int getNextPage();

		/**
		 * 返回上页的页号
		 */
		public int getPrePage();
	}
