package com.example.productsearchsystem.Service;

import com.example.productsearchsystem.Dao.ProductInfoRepository;
import com.example.productsearchsystem.Entity.Product;
import com.example.productsearchsystem.Entity.ProductInfo;
import com.univocity.parsers.csv.CsvParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UploadFileServiceImpl implements UpLoadFileService {

    private ProductInfoRepository productInfoRepository;

    private SolrSearchService solrSearchService;

    private CsvParser csvParser;

    public UploadFileServiceImpl(ProductInfoRepository productInfoRepository, CsvParser csvParser, SolrSearchService solrSearchService) {
        this.productInfoRepository = productInfoRepository;
        this.csvParser = csvParser;
        this.solrSearchService = solrSearchService;
    }

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("Please upload a non-empty file.");
        }

        List<ProductInfo> parsedProductInfos = new ArrayList<>();
        //Used to keep track of the line numbers
        long lineNumber = 0;

        parseFile(file, parsedProductInfos, lineNumber);

        List<ProductInfo> newProductInfos = new ArrayList<>();
        lineNumber = 0;
        //filter duplicate data by SkuID
        for (ProductInfo p : parsedProductInfos) {
            if (this.productInfoRepository.existsById(p.getSkuId())) {
                System.err.println("Skipping duplicate entry at line " + lineNumber + ":" + p);
                continue;
            }
            newProductInfos.add(p);
            lineNumber++;
        }

        try {
            productInfoRepository.saveAll(newProductInfos);
        } catch (Exception e) {
            System.err.println("Error save to MySQL DB: " + e.getMessage());
        }

        try {
            this.solrSearchService.saveAll(getProducts(newProductInfos));
        } catch (Exception e) {
            System.err.println("Error save to Solr Search: " + e.getMessage());
        }

        return "Upload file successful，total items: " + lineNumber;
    }

    private void parseFile(MultipartFile file, List<ProductInfo> parsedProductInfos, long lineNumber) throws IOException {
        try (InputStreamReader fileReader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)) {
            // Begin parsing the file, which returns a list of Records.
            List<com.univocity.parsers.common.record.Record> records = csvParser.parseAllRecords(fileReader);
            for (com.univocity.parsers.common.record.Record record : records) {
                try {
                    ProductInfo item = getProductInfo(record);
                    parsedProductInfos.add(item);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid sku_id at line " + lineNumber + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Required column missing at line " + lineNumber + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error processing record at line " + lineNumber + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading or parsing TSV file: " + e.getMessage());
            throw e;
        }
    }

    private List<Product> getProducts(List<ProductInfo> productInfos) {
        return productInfos.stream()
                .map(this::getProduct)
                .collect(Collectors.toList());
    }

    private Product getProduct(ProductInfo productInfo) {
        Product product = new Product();

        product.setSkuId(productInfo.getSkuId());
        product.setImage(productInfo.getImage());
        product.setAdditionalImageLink(productInfo.getAdditionalImageLink());
        product.setStyleId(productInfo.getStyleId());
        product.setClassId(productInfo.getClassId());
        product.setColor(productInfo.getColor());
        product.setColorCode(productInfo.getColorCode());
        product.setColorFamily(productInfo.getColorFamily());
        product.setSize(productInfo.getSize());
        product.setSizeId(productInfo.getSizeId());
        product.setDepartmentId(productInfo.getDepartmentId());
        product.setDissectionCode(productInfo.getDissectionCode());
        product.setHazmat(productInfo.getHazmat());
        product.setRedline(productInfo.getRedline());
        product.setPromoted(productInfo.getPromoted());
        product.setTaxCode(productInfo.getTaxCode());
        product.setVendor(productInfo.getVendor());
        product.setListPrice(productInfo.getListPrice());
        product.setSalePrice(productInfo.getSalePrice());
        product.setCurrency(productInfo.getCurrency());
        product.setShoprunnerEligible(productInfo.getShoprunnerEligible());
        product.setTitle(productInfo.getTitle());
        product.setLink(productInfo.getLink());
        product.setProdDescription(productInfo.getProdDescription());
        product.setFeaturedColor(productInfo.getFeaturedColor());
        product.setFeaturedColorCategory(productInfo.getFeaturedColorCategory());
        product.setRelatedProducts(productInfo.getRelatedProducts());
        product.setPreOrder(productInfo.getPreOrder());
        product.setHandlingCode(productInfo.getHandlingCode());
        product.setVideo(productInfo.getVideo());
        product.setProportion(productInfo.getProportion());
        product.setProportionProducts(productInfo.getProportionProducts());
        product.setMasterStyle(productInfo.getMasterStyle());
        product.setCannotReturn(productInfo.getCannotReturn());
        product.setGreatFind(productInfo.getGreatFind());
        product.setWebExclusive(productInfo.getWebExclusive());
        product.setNyDeals(productInfo.getNyDeals());
        product.setPromoTagline(productInfo.getPromoTagline());
        product.setPartiallyPromoted(productInfo.getPartiallyPromoted());
        product.setProductCategory(productInfo.getProductCategory());
        product.setSortOrder(productInfo.getSortOrder());
        product.setQuantitySold(productInfo.getQuantitySold());
        product.setAverageRating(productInfo.getAverageRating());

        return product;
    }

    private ProductInfo getProductInfo(com.univocity.parsers.common.record.Record record) {
        // Get values from record
        String skuId = record.getString("sku_id");
        String image = record.getString("image");
        String additionalImageLink = record.getString("additional_image_link");
        String styleId = record.getString("style_id");
        String classId = record.getString("class_id");
        String color = record.getString("color");
        String colorCode = record.getString("color_code");
        String colorFamily = record.getString("color_family");
        String size = record.getString("size");
        String sizeId = record.getString("size_id");
        String departmentId = record.getString("department_id");
        String dissectionCode = record.getString("dissection-code");
        String hazmat = record.getString("hazmat");
        String redline = record.getString("redline");
        String promoted = record.getString("promoted");
        String taxCode = record.getString("tax_code");
        String vendor = record.getString("vendor");

        double listPrice = 0.0;
        if (record.getDouble("list_price") != null) {
            listPrice = record.getDouble("list_price");
        }
        double salePrice = 0.0;
        if (record.getDouble("sale_price") != null) {
            salePrice = record.getDouble("sale_price");
        }

        String salePriceEffectiveDate = record.getString("sale_price_effective_date");
        String currency = record.getString("currency");
        String shoprunnerEligible = record.getString("shoprunner_eligible");
        String title = record.getString("title");
        String link = record.getString("link");
        String prodDescription = record.getString("prod_description");
        String startDate = record.getString("start_date");
        String featuredColor = record.getString("featured_color");
        String featuredColorCategory = record.getString("featured_color_category");
        String relatedProducts = record.getString("related_products");
        String preOrder = record.getString("pre_order");
        String handlingCode = record.getString("handling_code");
        String video = record.getString("video");
        String proportion = record.getString("proportion");
        String proportionProducts = record.getString("proportion_products");
        String masterStyle = record.getString("master_style");
        String cannotReturn = record.getString("cannot_return");
        String greatFind = record.getString("great_find");
        String webExclusive = record.getString("web_exclusive");
        String nyDeals = record.getString("ny_deals");
        String promoTagline = record.getString("promo_tagline");
        String partiallyPromoted = record.getString("partially_promoted");
        String productCategory = record.getString("product_category");
        String sortOrder = record.getString("sort_order");
        int quantitySold = 0;
        if (record.getInt("quantity_sold") != null) {
            record.getInt("quantity_sold");
        }
        double averageRating = 0.0;
        if (record.getDouble("average_rating") != null) {
            averageRating = record.getDouble("average_rating");
        }

        // Create ProductInfo
        ProductInfo product = new ProductInfo();

        product.setSkuId(Long.parseLong(skuId));
        product.setImage(image);
        product.setAdditionalImageLink(additionalImageLink);
        product.setStyleId(styleId);
        product.setClassId(classId);
        product.setColor(color);
        product.setColorCode(colorCode);
        product.setColorFamily(colorFamily);
        product.setSize(size);
        product.setSizeId(sizeId);
        product.setDepartmentId(departmentId);
        product.setDissectionCode(dissectionCode);
        product.setHazmat(hazmat);
        product.setRedline(redline);
        product.setPromoted(promoted);
        product.setTaxCode(taxCode);
        product.setVendor(vendor);
        product.setListPrice(listPrice);
        product.setSalePrice(salePrice);
        product.setSalePriceEffectiveDate(salePriceEffectiveDate);
        product.setCurrency(currency);
        product.setShoprunnerEligible(shoprunnerEligible);
        product.setTitle(title);
        product.setLink(link);
        product.setProdDescription(prodDescription);
        product.setStartDate(startDate);
        product.setFeaturedColor(featuredColor);
        product.setFeaturedColorCategory(featuredColorCategory);
        product.setRelatedProducts(relatedProducts);
        product.setPreOrder(preOrder);
        product.setHandlingCode(handlingCode);
        product.setVideo(video);
        product.setProportion(proportion);
        product.setProportionProducts(proportionProducts);
        product.setMasterStyle(masterStyle);
        product.setCannotReturn(cannotReturn);
        product.setGreatFind(greatFind);
        product.setWebExclusive(webExclusive);
        product.setNyDeals(nyDeals);
        product.setPromoTagline(promoTagline);
        product.setPartiallyPromoted(partiallyPromoted);
        product.setProductCategory(productCategory);
        product.setSortOrder(sortOrder);
        product.setQuantitySold(quantitySold);
        product.setAverageRating(averageRating);

        return product;
    }
}