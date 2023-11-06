package com.example.productsearchsystem.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "product_info")
public class ProductInfo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @Column(name = "sku_id")
    private Long skuId;

    @Column(name = "image")
    private String image;

    @Column(name = "additional_image_link")
    private String additionalImageLink;

    @Column(name = "style_id")
    private String styleId;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "color")
    private String color;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "color_family")
    private String colorFamily;

    @Column(name = "size")
    private String size;

    @Column(name = "size_id")
    private String sizeId;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "dissection_code")
    private String dissectionCode;

    @Column(name = "hazmat")
    private String hazmat;

    @Column(name = "redline")
    private String redline;

    @Column(name = "promoted")
    private String promoted;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "sale_price_effective_date")
    private String salePriceEffectiveDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "shoprunner_eligible")
    private String shoprunnerEligible;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "prod_description", length = 65555)
    private String prodDescription;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "featured_color")
    private String featuredColor;

    @Column(name = "featured_color_category")
    private String featuredColorCategory;

    @Column(name = "related_products")
    private String relatedProducts;

    @Column(name = "pre_order")
    private String preOrder;

    @Column(name = "handling_code")
    private String handlingCode;

    @Column(name = "video")
    private String video;

    @Column(name = "proportion")
    private String proportion;

    @Column(name = "proportion_products")
    private String proportionProducts;

    @Column(name = "master_style")
    private String masterStyle;

    @Column(name = "cannot_return")
    private String cannotReturn;

    @Column(name = "great_find")
    private String greatFind;

    @Column(name = "web_exclusive")
    private String webExclusive;

    @Column(name = "ny_deals")
    private String nyDeals;

    @Column(name = "promo_tagline")
    private String promoTagline;

    @Column(name = "partially_promoted")
    private String partiallyPromoted;

    @Column(name = "product_category", length = 65555)
    private String productCategory;

    @Column(name = "sort_order")
    private String sortOrder;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @Column(name = "average_rating")
    private Double averageRating;

    public ProductInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSalePriceEffectiveDate() {
        return salePriceEffectiveDate;
    }

    public void setSalePriceEffectiveDate(String salePriceEffectiveDate) {
        this.salePriceEffectiveDate = salePriceEffectiveDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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