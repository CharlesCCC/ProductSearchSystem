package com.example.productsearchsystem.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SolrDocument(collection = "Product") //case sensitive
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Indexed(name = "skuId", type = "string")
    private Long skuId;

    @Indexed(name = "image", type = "string")
    private String image;

    @Indexed(name = "additional_image_link", type = "string")
    private String additionalImageLink;

    @Indexed(name = "style_id", type = "string")
    private String styleId;

    @Indexed(name = "class_id", type = "string")
    private String classId;

    @Indexed(name = "color", type = "string")
    private String color;

    @Indexed(name = "color_code", type = "string")
    private String colorCode;

    @Indexed(name = "color_family", type = "string")
    private String colorFamily;

    @Indexed(name = "size", type = "string")
    private String size;

    @Indexed(name = "size_id", type = "string")
    private String sizeId;

    @Indexed(name = "department_id", type = "string")
    private String departmentId;

    @Indexed(name = "dissection_code", type = "string")
    private String dissectionCode;

    @Indexed(name = "hazmat", type = "string")
    private String hazmat;

    @Indexed(name = "redline", type = "string")
    private String redline;

    @Indexed(name = "promoted", type = "string")
    private String promoted;

    @Indexed(name = "tax_code", type = "string")
    private String taxCode;

    @Indexed(name = "vendor", type = "string")
    private String vendor;

    @Indexed(name = "list_price", type = "double")
    private double listPrice;

    @Indexed(name = "sale_price", type = "double")
    private double salePrice;

    @Indexed(name = "currency", type = "string")
    private String currency;

    @Indexed(name = "shoprunner_eligible", type = "string")
    private String shoprunnerEligible;

    @Indexed(name = "title", type = "string")
    private String title;

    @Indexed(name = "link", type = "string")
    private String link;

    @Indexed(name = "prod_description", type = "string")
    private String prodDescription;

    @Indexed(name = "featured_color", type = "string")
    private String featuredColor;

    @Indexed(name = "featured_color_category", type = "string")
    private String featuredColorCategory;

    @Indexed(name = "related_products", type = "string")
    private String relatedProducts;

    @Indexed(name = "pre_order", type = "string")
    private String preOrder;

    @Indexed(name = "handling_code", type = "string")
    private String handlingCode;

    @Indexed(name = "video", type = "string")
    private String video;

    @Indexed(name = "proportion", type = "string")
    private String proportion;

    @Indexed(name = "proportion_products", type = "string")
    private String proportionProducts;

    @Indexed(name = "master_style", type = "string")
    private String masterStyle;

    @Indexed(name = "cannot_return", type = "string")
    private String cannotReturn;

    @Indexed(name = "great_find", type = "string")
    private String greatFind;

    @Indexed(name = "web_exclusive", type = "string")
    private String webExclusive;

    @Indexed(name = "ny_deals", type = "string")
    private String nyDeals;

    @Indexed(name = "promo_tagline", type = "string")
    private String promoTagline;

    @Indexed(name = "partially_promoted", type = "string")
    private String partiallyPromoted;

    @Indexed(name = "product_category", type = "string")
    private String productCategory;

    @Indexed(name = "sort_order", type = "string")
    private String sortOrder;

    @Indexed(name = "quantity_sold", type = "int")
    private Integer quantitySold;

    @Indexed(name = "average_rating", type = "double")
    private Double averageRating;

    // Getters and setters

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdditionalImageLink() {
        return additionalImageLink;
    }

    public void setAdditionalImageLink(String additionalImageLink) {
        this.additionalImageLink = additionalImageLink;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorFamily() {
        return colorFamily;
    }

    public void setColorFamily(String colorFamily) {
        this.colorFamily = colorFamily;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDissectionCode() {
        return dissectionCode;
    }

    public void setDissectionCode(String dissectionCode) {
        this.dissectionCode = dissectionCode;
    }

    public String getHazmat() {
        return hazmat;
    }

    public void setHazmat(String hazmat) {
        this.hazmat = hazmat;
    }

    public String getRedline() {
        return redline;
    }

    public void setRedline(String redline) {
        this.redline = redline;
    }

    public String getPromoted() {
        return promoted;
    }

    public void setPromoted(String promoted) {
        this.promoted = promoted;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShoprunnerEligible() {
        return shoprunnerEligible;
    }

    public void setShoprunnerEligible(String shoprunnerEligible) {
        this.shoprunnerEligible = shoprunnerEligible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getFeaturedColor() {
        return featuredColor;
    }

    public void setFeaturedColor(String featuredColor) {
        this.featuredColor = featuredColor;
    }

    public String getFeaturedColorCategory() {
        return featuredColorCategory;
    }

    public void setFeaturedColorCategory(String featuredColorCategory) {
        this.featuredColorCategory = featuredColorCategory;
    }

    public String getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(String relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public String getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(String preOrder) {
        this.preOrder = preOrder;
    }

    public String getHandlingCode() {
        return handlingCode;
    }

    public void setHandlingCode(String handlingCode) {
        this.handlingCode = handlingCode;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getProportionProducts() {
        return proportionProducts;
    }

    public void setProportionProducts(String proportionProducts) {
        this.proportionProducts = proportionProducts;
    }

    public String getMasterStyle() {
        return masterStyle;
    }

    public void setMasterStyle(String masterStyle) {
        this.masterStyle = masterStyle;
    }

    public String getCannotReturn() {
        return cannotReturn;
    }

    public void setCannotReturn(String cannotReturn) {
        this.cannotReturn = cannotReturn;
    }

    public String getGreatFind() {
        return greatFind;
    }

    public void setGreatFind(String greatFind) {
        this.greatFind = greatFind;
    }

    public String getWebExclusive() {
        return webExclusive;
    }

    public void setWebExclusive(String webExclusive) {
        this.webExclusive = webExclusive;
    }

    public String getNyDeals() {
        return nyDeals;
    }

    public void setNyDeals(String nyDeals) {
        this.nyDeals = nyDeals;
    }

    public String getPromoTagline() {
        return promoTagline;
    }

    public void setPromoTagline(String promoTagline) {
        this.promoTagline = promoTagline;
    }

    public String getPartiallyPromoted() {
        return partiallyPromoted;
    }

    public void setPartiallyPromoted(String partiallyPromoted) {
        this.partiallyPromoted = partiallyPromoted;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
