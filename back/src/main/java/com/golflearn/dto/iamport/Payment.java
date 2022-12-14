package com.golflearn.dto.iamport;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Payment {
	@SerializedName("imp_uid")
	String imp_uid;
	
	@SerializedName("merchant_uid")
	String merchant_uid;
	
	@SerializedName("pay_method")
	String pay_method;
	
	@SerializedName("pg_provider")
	String pg_provider;
	
	@SerializedName("pg_tid")
	String pg_tid;
	
	@SerializedName("escrow")
	boolean escrow;
	
	@SerializedName("apply_num")
	String apply_num;
	
	@SerializedName("card_name")
	String card_name;
	
	@SerializedName("card_quota")
	int card_quota;
	
	@SerializedName("vbank_name")
	String vbank_name;
	
	@SerializedName("vbank_num")
	String vbank_num;
	
	@SerializedName("vbank_holder")
	String vbank_holder;
	
	@SerializedName("vbank_date")
	long vbank_date;
	
	@SerializedName("name")
	String name;
	
	@SerializedName("amount")
	BigDecimal amount;
	
	@SerializedName("cancel_amount")
	BigDecimal cancel_amount;
	
	@SerializedName("buyer_name")
	String buyer_name;
	
	@SerializedName("buyer_email")
	String buyer_email;
	
	@SerializedName("buyer_tel")
	String buyer_tel;
	
	@SerializedName("buyer_addr")
	String buyer_addr;
	
	@SerializedName("buyer_postcode")
	String buyer_postcode;
	
	@SerializedName("custom_data")
	String custom_data;
	
	@SerializedName("status")
	String status;
	
	@SerializedName("paid_at")
	long paid_at;
	
	@SerializedName("failed_at")
	long failed_at;
	
	@SerializedName("cancelled_at")
	long cancelled_at;
	
	@SerializedName("fail_reason")
	String fail_reason;
	
	@SerializedName("cancel_reason")
	String cancel_reason;
	
	@SerializedName("receipt_url")
	String receipt_url;
	
	public String getImpUid() {
		return imp_uid;
	}
	
	public String getMerchantUid() {
		return merchant_uid;
	}

	public String getPayMethod() {
		return pay_method;
	}

	public String getPgProvider() {
		return pg_provider;
	}

	public String getPgTid() {
		return pg_tid;
	}

	public boolean isEscrow() {
		return escrow;
	}

	public String getApplyNum() {
		return apply_num;
	}

	public String getCardName() {
		return card_name;
	}

	public int getCardQuota() {
		return card_quota;
	}

	public String getVbankName() {
		return vbank_name;
	}

	public String getVbankNum() {
		return vbank_num;
	}

	public String getVbankHolder() {
		return vbank_holder;
	}

	public Date getVbankDate() {
		return new Date( vbank_date * 1000L );
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getCancelAmount() {
		return cancel_amount;
	}

	public String getBuyerName() {
		return buyer_name;
	}

	public String getBuyerEmail() {
		return buyer_email;
	}

	public String getBuyerTel() {
		return buyer_tel;
	}

	public String getBuyerAddr() {
		return buyer_addr;
	}

	public String getBuyerPostcode() {
		return buyer_postcode;
	}

	public String getCustomData() {
		return custom_data;
	}

	public String getStatus() {
		return status;
	}

	public Date getPaidAt() {
		return new Date( paid_at * 1000L );
	}

	public Date getFailedAt() {
		return new Date( failed_at * 1000L );
	}

	public Date getCancelledAt() {
		return new Date( cancelled_at * 1000L );
	}

	public String getFailReason() {
		return fail_reason;
	}

	public String getCancelReason() {
		return cancel_reason;
	}

	public String getReceiptUrl() {
		return receipt_url;
	}
}
