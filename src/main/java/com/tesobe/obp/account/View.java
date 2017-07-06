package com.tesobe.obp.account;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "short_name", "description", "is_public", "alias",
		"hide_metadata_if_alias_used", "can_add_comment", "can_add_corporate_location",
		"can_add_image", "can_add_image_url", "can_add_more_info",
		"can_add_open_corporates_url", "can_add_physical_location",
		"can_add_private_alias", "can_add_public_alias", "can_add_tag", "can_add_url",
		"can_add_where_tag", "can_delete_comment", "can_add_counterparty",
		"can_delete_corporate_location", "can_delete_image",
		"can_delete_physical_location", "can_delete_tag", "can_delete_where_tag",
		"can_edit_owner_comment", "can_see_bank_account_balance",
		"can_see_bank_account_bank_name", "can_see_bank_account_currency",
		"can_see_bank_account_iban", "can_see_bank_account_label",
		"can_see_bank_account_national_identifier", "can_see_bank_account_number",
		"can_see_bank_account_owners", "can_see_bank_account_swift_bic",
		"can_see_bank_account_type", "can_see_comments", "can_see_corporate_location",
		"can_see_image_url", "can_see_images", "can_see_more_info",
		"can_see_open_corporates_url", "can_see_other_account_bank_name",
		"can_see_other_account_iban", "can_see_other_account_kind",
		"can_see_other_account_metadata", "can_see_other_account_national_identifier",
		"can_see_other_account_number", "can_see_other_account_swift_bic",
		"can_see_owner_comment", "can_see_physical_location", "can_see_private_alias",
		"can_see_public_alias", "can_see_tags", "can_see_transaction_amount",
		"can_see_transaction_balance", "can_see_transaction_currency",
		"can_see_transaction_description", "can_see_transaction_finish_date",
		"can_see_transaction_metadata", "can_see_transaction_other_bank_account",
		"can_see_transaction_start_date", "can_see_transaction_this_bank_account",
		"can_see_transaction_type", "can_see_url", "can_see_where_tag",
		"can_see_bank_routing_scheme", "can_see_bank_routing_address",
		"can_see_bank_account_routing_scheme", "can_see_bank_account_routing_address",
		"can_see_other_bank_routing_scheme", "can_see_other_bank_routing_address",
		"can_see_other_account_routing_scheme", "can_see_other_account_routing_address" })
public class View {

	@JsonProperty("id")
	private String id;
	@JsonProperty("short_name")
	private String shortName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("is_public")
	private Boolean isPublic;
	@JsonProperty("alias")
	private String alias;
	@JsonProperty("hide_metadata_if_alias_used")
	private Boolean hideMetadataIfAliasUsed;
	@JsonProperty("can_add_comment")
	private Boolean canAddComment;
	@JsonProperty("can_add_corporate_location")
	private Boolean canAddCorporateLocation;
	@JsonProperty("can_add_image")
	private Boolean canAddImage;
	@JsonProperty("can_add_image_url")
	private Boolean canAddImageUrl;
	@JsonProperty("can_add_more_info")
	private Boolean canAddMoreInfo;
	@JsonProperty("can_add_open_corporates_url")
	private Boolean canAddOpenCorporatesUrl;
	@JsonProperty("can_add_physical_location")
	private Boolean canAddPhysicalLocation;
	@JsonProperty("can_add_private_alias")
	private Boolean canAddPrivateAlias;
	@JsonProperty("can_add_public_alias")
	private Boolean canAddPublicAlias;
	@JsonProperty("can_add_tag")
	private Boolean canAddTag;
	@JsonProperty("can_add_url")
	private Boolean canAddUrl;
	@JsonProperty("can_add_where_tag")
	private Boolean canAddWhereTag;
	@JsonProperty("can_delete_comment")
	private Boolean canDeleteComment;
	@JsonProperty("can_add_counterparty")
	private Boolean canAddCounterparty;
	@JsonProperty("can_delete_corporate_location")
	private Boolean canDeleteCorporateLocation;
	@JsonProperty("can_delete_image")
	private Boolean canDeleteImage;
	@JsonProperty("can_delete_physical_location")
	private Boolean canDeletePhysicalLocation;
	@JsonProperty("can_delete_tag")
	private Boolean canDeleteTag;
	@JsonProperty("can_delete_where_tag")
	private Boolean canDeleteWhereTag;
	@JsonProperty("can_edit_owner_comment")
	private Boolean canEditOwnerComment;
	@JsonProperty("can_see_bank_account_balance")
	private Boolean canSeeBankAccountBalance;
	@JsonProperty("can_see_bank_account_bank_name")
	private Boolean canSeeBankAccountBankName;
	@JsonProperty("can_see_bank_account_currency")
	private Boolean canSeeBankAccountCurrency;
	@JsonProperty("can_see_bank_account_iban")
	private Boolean canSeeBankAccountIban;
	@JsonProperty("can_see_bank_account_label")
	private Boolean canSeeBankAccountLabel;
	@JsonProperty("can_see_bank_account_national_identifier")
	private Boolean canSeeBankAccountNationalIdentifier;
	@JsonProperty("can_see_bank_account_number")
	private Boolean canSeeBankAccountNumber;
	@JsonProperty("can_see_bank_account_owners")
	private Boolean canSeeBankAccountOwners;
	@JsonProperty("can_see_bank_account_swift_bic")
	private Boolean canSeeBankAccountSwiftBic;
	@JsonProperty("can_see_bank_account_type")
	private Boolean canSeeBankAccountType;
	@JsonProperty("can_see_comments")
	private Boolean canSeeComments;
	@JsonProperty("can_see_corporate_location")
	private Boolean canSeeCorporateLocation;
	@JsonProperty("can_see_image_url")
	private Boolean canSeeImageUrl;
	@JsonProperty("can_see_images")
	private Boolean canSeeImages;
	@JsonProperty("can_see_more_info")
	private Boolean canSeeMoreInfo;
	@JsonProperty("can_see_open_corporates_url")
	private Boolean canSeeOpenCorporatesUrl;
	@JsonProperty("can_see_other_account_bank_name")
	private Boolean canSeeOtherAccountBankName;
	@JsonProperty("can_see_other_account_iban")
	private Boolean canSeeOtherAccountIban;
	@JsonProperty("can_see_other_account_kind")
	private Boolean canSeeOtherAccountKind;
	@JsonProperty("can_see_other_account_metadata")
	private Boolean canSeeOtherAccountMetadata;
	@JsonProperty("can_see_other_account_national_identifier")
	private Boolean canSeeOtherAccountNationalIdentifier;
	@JsonProperty("can_see_other_account_number")
	private Boolean canSeeOtherAccountNumber;
	@JsonProperty("can_see_other_account_swift_bic")
	private Boolean canSeeOtherAccountSwiftBic;
	@JsonProperty("can_see_owner_comment")
	private Boolean canSeeOwnerComment;
	@JsonProperty("can_see_physical_location")
	private Boolean canSeePhysicalLocation;
	@JsonProperty("can_see_private_alias")
	private Boolean canSeePrivateAlias;
	@JsonProperty("can_see_public_alias")
	private Boolean canSeePublicAlias;
	@JsonProperty("can_see_tags")
	private Boolean canSeeTags;
	@JsonProperty("can_see_transaction_amount")
	private Boolean canSeeTransactionAmount;
	@JsonProperty("can_see_transaction_balance")
	private Boolean canSeeTransactionBalance;
	@JsonProperty("can_see_transaction_currency")
	private Boolean canSeeTransactionCurrency;
	@JsonProperty("can_see_transaction_description")
	private Boolean canSeeTransactionDescription;
	@JsonProperty("can_see_transaction_finish_date")
	private Boolean canSeeTransactionFinishDate;
	@JsonProperty("can_see_transaction_metadata")
	private Boolean canSeeTransactionMetadata;
	@JsonProperty("can_see_transaction_other_bank_account")
	private Boolean canSeeTransactionOtherBankAccount;
	@JsonProperty("can_see_transaction_start_date")
	private Boolean canSeeTransactionStartDate;
	@JsonProperty("can_see_transaction_this_bank_account")
	private Boolean canSeeTransactionThisBankAccount;
	@JsonProperty("can_see_transaction_type")
	private Boolean canSeeTransactionType;
	@JsonProperty("can_see_url")
	private Boolean canSeeUrl;
	@JsonProperty("can_see_where_tag")
	private Boolean canSeeWhereTag;
	@JsonProperty("can_see_bank_routing_scheme")
	private Boolean canSeeBankRoutingScheme;
	@JsonProperty("can_see_bank_routing_address")
	private Boolean canSeeBankRoutingAddress;
	@JsonProperty("can_see_bank_account_routing_scheme")
	private Boolean canSeeBankAccountRoutingScheme;
	@JsonProperty("can_see_bank_account_routing_address")
	private Boolean canSeeBankAccountRoutingAddress;
	@JsonProperty("can_see_other_bank_routing_scheme")
	private Boolean canSeeOtherBankRoutingScheme;
	@JsonProperty("can_see_other_bank_routing_address")
	private Boolean canSeeOtherBankRoutingAddress;
	@JsonProperty("can_see_other_account_routing_scheme")
	private Boolean canSeeOtherAccountRoutingScheme;
	@JsonProperty("can_see_other_account_routing_address")
	private Boolean canSeeOtherAccountRoutingAddress;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("short_name")
	public String getShortName() {
		return shortName;
	}

	@JsonProperty("short_name")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("is_public")
	public Boolean getIsPublic() {
		return isPublic;
	}

	@JsonProperty("is_public")
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	@JsonProperty("alias")
	public String getAlias() {
		return alias;
	}

	@JsonProperty("alias")
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@JsonProperty("hide_metadata_if_alias_used")
	public Boolean getHideMetadataIfAliasUsed() {
		return hideMetadataIfAliasUsed;
	}

	@JsonProperty("hide_metadata_if_alias_used")
	public void setHideMetadataIfAliasUsed(Boolean hideMetadataIfAliasUsed) {
		this.hideMetadataIfAliasUsed = hideMetadataIfAliasUsed;
	}

	@JsonProperty("can_add_comment")
	public Boolean getCanAddComment() {
		return canAddComment;
	}

	@JsonProperty("can_add_comment")
	public void setCanAddComment(Boolean canAddComment) {
		this.canAddComment = canAddComment;
	}

	@JsonProperty("can_add_corporate_location")
	public Boolean getCanAddCorporateLocation() {
		return canAddCorporateLocation;
	}

	@JsonProperty("can_add_corporate_location")
	public void setCanAddCorporateLocation(Boolean canAddCorporateLocation) {
		this.canAddCorporateLocation = canAddCorporateLocation;
	}

	@JsonProperty("can_add_image")
	public Boolean getCanAddImage() {
		return canAddImage;
	}

	@JsonProperty("can_add_image")
	public void setCanAddImage(Boolean canAddImage) {
		this.canAddImage = canAddImage;
	}

	@JsonProperty("can_add_image_url")
	public Boolean getCanAddImageUrl() {
		return canAddImageUrl;
	}

	@JsonProperty("can_add_image_url")
	public void setCanAddImageUrl(Boolean canAddImageUrl) {
		this.canAddImageUrl = canAddImageUrl;
	}

	@JsonProperty("can_add_more_info")
	public Boolean getCanAddMoreInfo() {
		return canAddMoreInfo;
	}

	@JsonProperty("can_add_more_info")
	public void setCanAddMoreInfo(Boolean canAddMoreInfo) {
		this.canAddMoreInfo = canAddMoreInfo;
	}

	@JsonProperty("can_add_open_corporates_url")
	public Boolean getCanAddOpenCorporatesUrl() {
		return canAddOpenCorporatesUrl;
	}

	@JsonProperty("can_add_open_corporates_url")
	public void setCanAddOpenCorporatesUrl(Boolean canAddOpenCorporatesUrl) {
		this.canAddOpenCorporatesUrl = canAddOpenCorporatesUrl;
	}

	@JsonProperty("can_add_physical_location")
	public Boolean getCanAddPhysicalLocation() {
		return canAddPhysicalLocation;
	}

	@JsonProperty("can_add_physical_location")
	public void setCanAddPhysicalLocation(Boolean canAddPhysicalLocation) {
		this.canAddPhysicalLocation = canAddPhysicalLocation;
	}

	@JsonProperty("can_add_private_alias")
	public Boolean getCanAddPrivateAlias() {
		return canAddPrivateAlias;
	}

	@JsonProperty("can_add_private_alias")
	public void setCanAddPrivateAlias(Boolean canAddPrivateAlias) {
		this.canAddPrivateAlias = canAddPrivateAlias;
	}

	@JsonProperty("can_add_public_alias")
	public Boolean getCanAddPublicAlias() {
		return canAddPublicAlias;
	}

	@JsonProperty("can_add_public_alias")
	public void setCanAddPublicAlias(Boolean canAddPublicAlias) {
		this.canAddPublicAlias = canAddPublicAlias;
	}

	@JsonProperty("can_add_tag")
	public Boolean getCanAddTag() {
		return canAddTag;
	}

	@JsonProperty("can_add_tag")
	public void setCanAddTag(Boolean canAddTag) {
		this.canAddTag = canAddTag;
	}

	@JsonProperty("can_add_url")
	public Boolean getCanAddUrl() {
		return canAddUrl;
	}

	@JsonProperty("can_add_url")
	public void setCanAddUrl(Boolean canAddUrl) {
		this.canAddUrl = canAddUrl;
	}

	@JsonProperty("can_add_where_tag")
	public Boolean getCanAddWhereTag() {
		return canAddWhereTag;
	}

	@JsonProperty("can_add_where_tag")
	public void setCanAddWhereTag(Boolean canAddWhereTag) {
		this.canAddWhereTag = canAddWhereTag;
	}

	@JsonProperty("can_delete_comment")
	public Boolean getCanDeleteComment() {
		return canDeleteComment;
	}

	@JsonProperty("can_delete_comment")
	public void setCanDeleteComment(Boolean canDeleteComment) {
		this.canDeleteComment = canDeleteComment;
	}

	@JsonProperty("can_add_counterparty")
	public Boolean getCanAddCounterparty() {
		return canAddCounterparty;
	}

	@JsonProperty("can_add_counterparty")
	public void setCanAddCounterparty(Boolean canAddCounterparty) {
		this.canAddCounterparty = canAddCounterparty;
	}

	@JsonProperty("can_delete_corporate_location")
	public Boolean getCanDeleteCorporateLocation() {
		return canDeleteCorporateLocation;
	}

	@JsonProperty("can_delete_corporate_location")
	public void setCanDeleteCorporateLocation(Boolean canDeleteCorporateLocation) {
		this.canDeleteCorporateLocation = canDeleteCorporateLocation;
	}

	@JsonProperty("can_delete_image")
	public Boolean getCanDeleteImage() {
		return canDeleteImage;
	}

	@JsonProperty("can_delete_image")
	public void setCanDeleteImage(Boolean canDeleteImage) {
		this.canDeleteImage = canDeleteImage;
	}

	@JsonProperty("can_delete_physical_location")
	public Boolean getCanDeletePhysicalLocation() {
		return canDeletePhysicalLocation;
	}

	@JsonProperty("can_delete_physical_location")
	public void setCanDeletePhysicalLocation(Boolean canDeletePhysicalLocation) {
		this.canDeletePhysicalLocation = canDeletePhysicalLocation;
	}

	@JsonProperty("can_delete_tag")
	public Boolean getCanDeleteTag() {
		return canDeleteTag;
	}

	@JsonProperty("can_delete_tag")
	public void setCanDeleteTag(Boolean canDeleteTag) {
		this.canDeleteTag = canDeleteTag;
	}

	@JsonProperty("can_delete_where_tag")
	public Boolean getCanDeleteWhereTag() {
		return canDeleteWhereTag;
	}

	@JsonProperty("can_delete_where_tag")
	public void setCanDeleteWhereTag(Boolean canDeleteWhereTag) {
		this.canDeleteWhereTag = canDeleteWhereTag;
	}

	@JsonProperty("can_edit_owner_comment")
	public Boolean getCanEditOwnerComment() {
		return canEditOwnerComment;
	}

	@JsonProperty("can_edit_owner_comment")
	public void setCanEditOwnerComment(Boolean canEditOwnerComment) {
		this.canEditOwnerComment = canEditOwnerComment;
	}

	@JsonProperty("can_see_bank_account_balance")
	public Boolean getCanSeeBankAccountBalance() {
		return canSeeBankAccountBalance;
	}

	@JsonProperty("can_see_bank_account_balance")
	public void setCanSeeBankAccountBalance(Boolean canSeeBankAccountBalance) {
		this.canSeeBankAccountBalance = canSeeBankAccountBalance;
	}

	@JsonProperty("can_see_bank_account_bank_name")
	public Boolean getCanSeeBankAccountBankName() {
		return canSeeBankAccountBankName;
	}

	@JsonProperty("can_see_bank_account_bank_name")
	public void setCanSeeBankAccountBankName(Boolean canSeeBankAccountBankName) {
		this.canSeeBankAccountBankName = canSeeBankAccountBankName;
	}

	@JsonProperty("can_see_bank_account_currency")
	public Boolean getCanSeeBankAccountCurrency() {
		return canSeeBankAccountCurrency;
	}

	@JsonProperty("can_see_bank_account_currency")
	public void setCanSeeBankAccountCurrency(Boolean canSeeBankAccountCurrency) {
		this.canSeeBankAccountCurrency = canSeeBankAccountCurrency;
	}

	@JsonProperty("can_see_bank_account_iban")
	public Boolean getCanSeeBankAccountIban() {
		return canSeeBankAccountIban;
	}

	@JsonProperty("can_see_bank_account_iban")
	public void setCanSeeBankAccountIban(Boolean canSeeBankAccountIban) {
		this.canSeeBankAccountIban = canSeeBankAccountIban;
	}

	@JsonProperty("can_see_bank_account_label")
	public Boolean getCanSeeBankAccountLabel() {
		return canSeeBankAccountLabel;
	}

	@JsonProperty("can_see_bank_account_label")
	public void setCanSeeBankAccountLabel(Boolean canSeeBankAccountLabel) {
		this.canSeeBankAccountLabel = canSeeBankAccountLabel;
	}

	@JsonProperty("can_see_bank_account_national_identifier")
	public Boolean getCanSeeBankAccountNationalIdentifier() {
		return canSeeBankAccountNationalIdentifier;
	}

	@JsonProperty("can_see_bank_account_national_identifier")
	public void setCanSeeBankAccountNationalIdentifier(
			Boolean canSeeBankAccountNationalIdentifier) {
		this.canSeeBankAccountNationalIdentifier = canSeeBankAccountNationalIdentifier;
	}

	@JsonProperty("can_see_bank_account_number")
	public Boolean getCanSeeBankAccountNumber() {
		return canSeeBankAccountNumber;
	}

	@JsonProperty("can_see_bank_account_number")
	public void setCanSeeBankAccountNumber(Boolean canSeeBankAccountNumber) {
		this.canSeeBankAccountNumber = canSeeBankAccountNumber;
	}

	@JsonProperty("can_see_bank_account_owners")
	public Boolean getCanSeeBankAccountOwners() {
		return canSeeBankAccountOwners;
	}

	@JsonProperty("can_see_bank_account_owners")
	public void setCanSeeBankAccountOwners(Boolean canSeeBankAccountOwners) {
		this.canSeeBankAccountOwners = canSeeBankAccountOwners;
	}

	@JsonProperty("can_see_bank_account_swift_bic")
	public Boolean getCanSeeBankAccountSwiftBic() {
		return canSeeBankAccountSwiftBic;
	}

	@JsonProperty("can_see_bank_account_swift_bic")
	public void setCanSeeBankAccountSwiftBic(Boolean canSeeBankAccountSwiftBic) {
		this.canSeeBankAccountSwiftBic = canSeeBankAccountSwiftBic;
	}

	@JsonProperty("can_see_bank_account_type")
	public Boolean getCanSeeBankAccountType() {
		return canSeeBankAccountType;
	}

	@JsonProperty("can_see_bank_account_type")
	public void setCanSeeBankAccountType(Boolean canSeeBankAccountType) {
		this.canSeeBankAccountType = canSeeBankAccountType;
	}

	@JsonProperty("can_see_comments")
	public Boolean getCanSeeComments() {
		return canSeeComments;
	}

	@JsonProperty("can_see_comments")
	public void setCanSeeComments(Boolean canSeeComments) {
		this.canSeeComments = canSeeComments;
	}

	@JsonProperty("can_see_corporate_location")
	public Boolean getCanSeeCorporateLocation() {
		return canSeeCorporateLocation;
	}

	@JsonProperty("can_see_corporate_location")
	public void setCanSeeCorporateLocation(Boolean canSeeCorporateLocation) {
		this.canSeeCorporateLocation = canSeeCorporateLocation;
	}

	@JsonProperty("can_see_image_url")
	public Boolean getCanSeeImageUrl() {
		return canSeeImageUrl;
	}

	@JsonProperty("can_see_image_url")
	public void setCanSeeImageUrl(Boolean canSeeImageUrl) {
		this.canSeeImageUrl = canSeeImageUrl;
	}

	@JsonProperty("can_see_images")
	public Boolean getCanSeeImages() {
		return canSeeImages;
	}

	@JsonProperty("can_see_images")
	public void setCanSeeImages(Boolean canSeeImages) {
		this.canSeeImages = canSeeImages;
	}

	@JsonProperty("can_see_more_info")
	public Boolean getCanSeeMoreInfo() {
		return canSeeMoreInfo;
	}

	@JsonProperty("can_see_more_info")
	public void setCanSeeMoreInfo(Boolean canSeeMoreInfo) {
		this.canSeeMoreInfo = canSeeMoreInfo;
	}

	@JsonProperty("can_see_open_corporates_url")
	public Boolean getCanSeeOpenCorporatesUrl() {
		return canSeeOpenCorporatesUrl;
	}

	@JsonProperty("can_see_open_corporates_url")
	public void setCanSeeOpenCorporatesUrl(Boolean canSeeOpenCorporatesUrl) {
		this.canSeeOpenCorporatesUrl = canSeeOpenCorporatesUrl;
	}

	@JsonProperty("can_see_other_account_bank_name")
	public Boolean getCanSeeOtherAccountBankName() {
		return canSeeOtherAccountBankName;
	}

	@JsonProperty("can_see_other_account_bank_name")
	public void setCanSeeOtherAccountBankName(Boolean canSeeOtherAccountBankName) {
		this.canSeeOtherAccountBankName = canSeeOtherAccountBankName;
	}

	@JsonProperty("can_see_other_account_iban")
	public Boolean getCanSeeOtherAccountIban() {
		return canSeeOtherAccountIban;
	}

	@JsonProperty("can_see_other_account_iban")
	public void setCanSeeOtherAccountIban(Boolean canSeeOtherAccountIban) {
		this.canSeeOtherAccountIban = canSeeOtherAccountIban;
	}

	@JsonProperty("can_see_other_account_kind")
	public Boolean getCanSeeOtherAccountKind() {
		return canSeeOtherAccountKind;
	}

	@JsonProperty("can_see_other_account_kind")
	public void setCanSeeOtherAccountKind(Boolean canSeeOtherAccountKind) {
		this.canSeeOtherAccountKind = canSeeOtherAccountKind;
	}

	@JsonProperty("can_see_other_account_metadata")
	public Boolean getCanSeeOtherAccountMetadata() {
		return canSeeOtherAccountMetadata;
	}

	@JsonProperty("can_see_other_account_metadata")
	public void setCanSeeOtherAccountMetadata(Boolean canSeeOtherAccountMetadata) {
		this.canSeeOtherAccountMetadata = canSeeOtherAccountMetadata;
	}

	@JsonProperty("can_see_other_account_national_identifier")
	public Boolean getCanSeeOtherAccountNationalIdentifier() {
		return canSeeOtherAccountNationalIdentifier;
	}

	@JsonProperty("can_see_other_account_national_identifier")
	public void setCanSeeOtherAccountNationalIdentifier(
			Boolean canSeeOtherAccountNationalIdentifier) {
		this.canSeeOtherAccountNationalIdentifier = canSeeOtherAccountNationalIdentifier;
	}

	@JsonProperty("can_see_other_account_number")
	public Boolean getCanSeeOtherAccountNumber() {
		return canSeeOtherAccountNumber;
	}

	@JsonProperty("can_see_other_account_number")
	public void setCanSeeOtherAccountNumber(Boolean canSeeOtherAccountNumber) {
		this.canSeeOtherAccountNumber = canSeeOtherAccountNumber;
	}

	@JsonProperty("can_see_other_account_swift_bic")
	public Boolean getCanSeeOtherAccountSwiftBic() {
		return canSeeOtherAccountSwiftBic;
	}

	@JsonProperty("can_see_other_account_swift_bic")
	public void setCanSeeOtherAccountSwiftBic(Boolean canSeeOtherAccountSwiftBic) {
		this.canSeeOtherAccountSwiftBic = canSeeOtherAccountSwiftBic;
	}

	@JsonProperty("can_see_owner_comment")
	public Boolean getCanSeeOwnerComment() {
		return canSeeOwnerComment;
	}

	@JsonProperty("can_see_owner_comment")
	public void setCanSeeOwnerComment(Boolean canSeeOwnerComment) {
		this.canSeeOwnerComment = canSeeOwnerComment;
	}

	@JsonProperty("can_see_physical_location")
	public Boolean getCanSeePhysicalLocation() {
		return canSeePhysicalLocation;
	}

	@JsonProperty("can_see_physical_location")
	public void setCanSeePhysicalLocation(Boolean canSeePhysicalLocation) {
		this.canSeePhysicalLocation = canSeePhysicalLocation;
	}

	@JsonProperty("can_see_private_alias")
	public Boolean getCanSeePrivateAlias() {
		return canSeePrivateAlias;
	}

	@JsonProperty("can_see_private_alias")
	public void setCanSeePrivateAlias(Boolean canSeePrivateAlias) {
		this.canSeePrivateAlias = canSeePrivateAlias;
	}

	@JsonProperty("can_see_public_alias")
	public Boolean getCanSeePublicAlias() {
		return canSeePublicAlias;
	}

	@JsonProperty("can_see_public_alias")
	public void setCanSeePublicAlias(Boolean canSeePublicAlias) {
		this.canSeePublicAlias = canSeePublicAlias;
	}

	@JsonProperty("can_see_tags")
	public Boolean getCanSeeTags() {
		return canSeeTags;
	}

	@JsonProperty("can_see_tags")
	public void setCanSeeTags(Boolean canSeeTags) {
		this.canSeeTags = canSeeTags;
	}

	@JsonProperty("can_see_transaction_amount")
	public Boolean getCanSeeTransactionAmount() {
		return canSeeTransactionAmount;
	}

	@JsonProperty("can_see_transaction_amount")
	public void setCanSeeTransactionAmount(Boolean canSeeTransactionAmount) {
		this.canSeeTransactionAmount = canSeeTransactionAmount;
	}

	@JsonProperty("can_see_transaction_balance")
	public Boolean getCanSeeTransactionBalance() {
		return canSeeTransactionBalance;
	}

	@JsonProperty("can_see_transaction_balance")
	public void setCanSeeTransactionBalance(Boolean canSeeTransactionBalance) {
		this.canSeeTransactionBalance = canSeeTransactionBalance;
	}

	@JsonProperty("can_see_transaction_currency")
	public Boolean getCanSeeTransactionCurrency() {
		return canSeeTransactionCurrency;
	}

	@JsonProperty("can_see_transaction_currency")
	public void setCanSeeTransactionCurrency(Boolean canSeeTransactionCurrency) {
		this.canSeeTransactionCurrency = canSeeTransactionCurrency;
	}

	@JsonProperty("can_see_transaction_description")
	public Boolean getCanSeeTransactionDescription() {
		return canSeeTransactionDescription;
	}

	@JsonProperty("can_see_transaction_description")
	public void setCanSeeTransactionDescription(Boolean canSeeTransactionDescription) {
		this.canSeeTransactionDescription = canSeeTransactionDescription;
	}

	@JsonProperty("can_see_transaction_finish_date")
	public Boolean getCanSeeTransactionFinishDate() {
		return canSeeTransactionFinishDate;
	}

	@JsonProperty("can_see_transaction_finish_date")
	public void setCanSeeTransactionFinishDate(Boolean canSeeTransactionFinishDate) {
		this.canSeeTransactionFinishDate = canSeeTransactionFinishDate;
	}

	@JsonProperty("can_see_transaction_metadata")
	public Boolean getCanSeeTransactionMetadata() {
		return canSeeTransactionMetadata;
	}

	@JsonProperty("can_see_transaction_metadata")
	public void setCanSeeTransactionMetadata(Boolean canSeeTransactionMetadata) {
		this.canSeeTransactionMetadata = canSeeTransactionMetadata;
	}

	@JsonProperty("can_see_transaction_other_bank_account")
	public Boolean getCanSeeTransactionOtherBankAccount() {
		return canSeeTransactionOtherBankAccount;
	}

	@JsonProperty("can_see_transaction_other_bank_account")
	public void setCanSeeTransactionOtherBankAccount(
			Boolean canSeeTransactionOtherBankAccount) {
		this.canSeeTransactionOtherBankAccount = canSeeTransactionOtherBankAccount;
	}

	@JsonProperty("can_see_transaction_start_date")
	public Boolean getCanSeeTransactionStartDate() {
		return canSeeTransactionStartDate;
	}

	@JsonProperty("can_see_transaction_start_date")
	public void setCanSeeTransactionStartDate(Boolean canSeeTransactionStartDate) {
		this.canSeeTransactionStartDate = canSeeTransactionStartDate;
	}

	@JsonProperty("can_see_transaction_this_bank_account")
	public Boolean getCanSeeTransactionThisBankAccount() {
		return canSeeTransactionThisBankAccount;
	}

	@JsonProperty("can_see_transaction_this_bank_account")
	public void setCanSeeTransactionThisBankAccount(
			Boolean canSeeTransactionThisBankAccount) {
		this.canSeeTransactionThisBankAccount = canSeeTransactionThisBankAccount;
	}

	@JsonProperty("can_see_transaction_type")
	public Boolean getCanSeeTransactionType() {
		return canSeeTransactionType;
	}

	@JsonProperty("can_see_transaction_type")
	public void setCanSeeTransactionType(Boolean canSeeTransactionType) {
		this.canSeeTransactionType = canSeeTransactionType;
	}

	@JsonProperty("can_see_url")
	public Boolean getCanSeeUrl() {
		return canSeeUrl;
	}

	@JsonProperty("can_see_url")
	public void setCanSeeUrl(Boolean canSeeUrl) {
		this.canSeeUrl = canSeeUrl;
	}

	@JsonProperty("can_see_where_tag")
	public Boolean getCanSeeWhereTag() {
		return canSeeWhereTag;
	}

	@JsonProperty("can_see_where_tag")
	public void setCanSeeWhereTag(Boolean canSeeWhereTag) {
		this.canSeeWhereTag = canSeeWhereTag;
	}

	@JsonProperty("can_see_bank_routing_scheme")
	public Boolean getCanSeeBankRoutingScheme() {
		return canSeeBankRoutingScheme;
	}

	@JsonProperty("can_see_bank_routing_scheme")
	public void setCanSeeBankRoutingScheme(Boolean canSeeBankRoutingScheme) {
		this.canSeeBankRoutingScheme = canSeeBankRoutingScheme;
	}

	@JsonProperty("can_see_bank_routing_address")
	public Boolean getCanSeeBankRoutingAddress() {
		return canSeeBankRoutingAddress;
	}

	@JsonProperty("can_see_bank_routing_address")
	public void setCanSeeBankRoutingAddress(Boolean canSeeBankRoutingAddress) {
		this.canSeeBankRoutingAddress = canSeeBankRoutingAddress;
	}

	@JsonProperty("can_see_bank_account_routing_scheme")
	public Boolean getCanSeeBankAccountRoutingScheme() {
		return canSeeBankAccountRoutingScheme;
	}

	@JsonProperty("can_see_bank_account_routing_scheme")
	public void setCanSeeBankAccountRoutingScheme(
			Boolean canSeeBankAccountRoutingScheme) {
		this.canSeeBankAccountRoutingScheme = canSeeBankAccountRoutingScheme;
	}

	@JsonProperty("can_see_bank_account_routing_address")
	public Boolean getCanSeeBankAccountRoutingAddress() {
		return canSeeBankAccountRoutingAddress;
	}

	@JsonProperty("can_see_bank_account_routing_address")
	public void setCanSeeBankAccountRoutingAddress(
			Boolean canSeeBankAccountRoutingAddress) {
		this.canSeeBankAccountRoutingAddress = canSeeBankAccountRoutingAddress;
	}

	@JsonProperty("can_see_other_bank_routing_scheme")
	public Boolean getCanSeeOtherBankRoutingScheme() {
		return canSeeOtherBankRoutingScheme;
	}

	@JsonProperty("can_see_other_bank_routing_scheme")
	public void setCanSeeOtherBankRoutingScheme(Boolean canSeeOtherBankRoutingScheme) {
		this.canSeeOtherBankRoutingScheme = canSeeOtherBankRoutingScheme;
	}

	@JsonProperty("can_see_other_bank_routing_address")
	public Boolean getCanSeeOtherBankRoutingAddress() {
		return canSeeOtherBankRoutingAddress;
	}

	@JsonProperty("can_see_other_bank_routing_address")
	public void setCanSeeOtherBankRoutingAddress(Boolean canSeeOtherBankRoutingAddress) {
		this.canSeeOtherBankRoutingAddress = canSeeOtherBankRoutingAddress;
	}

	@JsonProperty("can_see_other_account_routing_scheme")
	public Boolean getCanSeeOtherAccountRoutingScheme() {
		return canSeeOtherAccountRoutingScheme;
	}

	@JsonProperty("can_see_other_account_routing_scheme")
	public void setCanSeeOtherAccountRoutingScheme(
			Boolean canSeeOtherAccountRoutingScheme) {
		this.canSeeOtherAccountRoutingScheme = canSeeOtherAccountRoutingScheme;
	}

	@JsonProperty("can_see_other_account_routing_address")
	public Boolean getCanSeeOtherAccountRoutingAddress() {
		return canSeeOtherAccountRoutingAddress;
	}

	@JsonProperty("can_see_other_account_routing_address")
	public void setCanSeeOtherAccountRoutingAddress(
			Boolean canSeeOtherAccountRoutingAddress) {
		this.canSeeOtherAccountRoutingAddress = canSeeOtherAccountRoutingAddress;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
