package youtube.krishnaitprojects.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrdersVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int order_Id;

	private String order_No;

	private int order_Count;

	private List<String> order_StatusList; // NotYeTOrdered, InCart, Ordered, Approved, Waiting, Declined, Dispatched,
									// Delivered, Returned

	private Date order_OrderedDate;

	private Date order_DispatchedDate;

	private Date order_DeliveredDate;

	private Date order_ReturnedDate;

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public String getOrder_No() {
		return order_No;
	}

	public void setOrder_No(String order_No) {
		this.order_No = order_No;
	}

	public int getOrder_Count() {
		return order_Count;
	}

	public void setOrder_Count(int order_Count) {
		this.order_Count = order_Count;
	}

	public List<String> getOrder_StatusList() {
		return order_StatusList;
	}

	public void setOrder_StatusList(List<String> order_StatusList) {
		this.order_StatusList = order_StatusList;
	}

	public Date getOrder_OrderedDate() {
		return order_OrderedDate;
	}

	public void setOrder_OrderedDate(Date order_OrderedDate) {
		this.order_OrderedDate = order_OrderedDate;
	}

	public Date getOrder_DispatchedDate() {
		return order_DispatchedDate;
	}

	public void setOrder_DispatchedDate(Date order_DispatchedDate) {
		this.order_DispatchedDate = order_DispatchedDate;
	}

	public Date getOrder_DeliveredDate() {
		return order_DeliveredDate;
	}

	public void setOrder_DeliveredDate(Date order_DeliveredDate) {
		this.order_DeliveredDate = order_DeliveredDate;
	}

	public Date getOrder_ReturnedDate() {
		return order_ReturnedDate;
	}

	public void setOrder_ReturnedDate(Date order_ReturnedDate) {
		this.order_ReturnedDate = order_ReturnedDate;
	}

}
