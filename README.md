# ProductSearchSystem
ProductSearchSystem with the support of upload CSV/TSV file via POST API and backup to MySQL DB, then all the data get feed back into Solr search. There is GET API to perform search. 

# Deployment doc
* Tool Prerequisite:   \
(detail installation on local machine is out of scope of this doc, please reference online doc on how to install each of the following) 
    * Java 11+ 
    * Postman API testing tool (test collections attached, please import) 
    * MySQL local DB version 8.X 
    * Solr local setup 
* Tool configuration:
    * Postman - please import the attached tests collection APIs 
    * MySQL config:
        * DBurl=jdbc:mysql://localhost:3306/ProductSearchSystem?useSSL=false&serverTimezone=UTC
        * username=springstudent
        * password=springstudent
    * Solr config (make sure it is running at) 
        * host=[http://localhost:8983/solr](http://localhost:8983/solr)
        * Create “Product” collection within the Solr webUI 
* Run Spring-boot locally
    * Open terminal and cd to the director where contains the `jar` file 
    * Run `java -jar ProductSearchSystem-0.0.1-SNAPSHOT.jar` 
        * Service running at  `http://localhost:8080`
    * Then you can use Postman to call each API like the following 
        * test collections “**PS-POS.postman_collection.json**” attached, please import to postman


# API Demo:

## FileUpload API

<img width="829" alt="image" src="https://github.com/CharlesCCC/ProductSearchSystem/assets/7534809/85c99e4d-fe46-458e-9531-e18b2aff22d3">


## ProductController API

This API provides endpoints for managing products info in Solr 


### Find Products by Description

Search for products by description.

URL: /api/v1/product/desc/{prodDesc}/{page}/{pageSize}

Method: GET

Path Parameters:



* prodDesc (required): The description to search for.
* page (required): The page number of the result set.
* pageSize (required): The maximum number of products per page.

Response:



* Status Code: 200 OK
* Body: List of Product objects

<img width="832" alt="image" src="https://github.com/CharlesCCC/ProductSearchSystem/assets/7534809/5f164014-156a-4ecb-8d5c-003dc007dc34">



### Find Products by Search Term

Search for products using a custom search term. (e.g. search by description, title, size, color, product category) 

URL: /api/v1/product/search/{searchTerm}/{page}/{pageSize}

Method: GET

Path Parameters:



* searchTerm (required): The search term to use.
* page (required): The page number of the result set.
* pageSize (required): The maximum number of products per page.

Response:



* Status Code: 200 OK
* Body: List of Product objects


<img width="827" alt="image" src="https://github.com/CharlesCCC/ProductSearchSystem/assets/7534809/309a1784-ec41-4cea-949c-502e33de4d20">




### **Create Product**

Create a new product.

URL: /api/v1/product

Method: POST

Request Body:

{

  "skuId": "ABC124",

  "image": "example.jpg",

  "additionalImageLink": "example2.jpg",

  "styleId": "12345",

  "classId": "67890",

  "color": "Black",

  "colorCode": "#FF0000",

  "colorFamily": "Warm",

  "size": "M",

  "sizeId": "123",

  "departmentId": "456",

  "dissectionCode": "XYZ",

  "hazmat": "No",

  "redline": "No",

  "promoted": "Yes",

  "taxCode": "TAX123",

  "vendor": "Example Vendor",

  "listPrice": 29.99,

  "salePrice": 19.99,

  "salePriceEffectiveDate": "2023-11-05",

  "currency": "USD",

  "shoprunnerEligible": "Yes",

  "title": "Example Product",

  "link": "https://example.com/product",

  "prodDescription": "This is an example product.",

  "startDate": "2023-11-01",

  "featuredColor": "Blue",

  "featuredColorCategory": "Cool",

  "relatedProducts": "Related Product 1, Related Product 2",

  "preOrder": "No",

  "handlingCode": "HNDL123",

  "video": "https://example.com/video",

  "proportion": "1:2",

  "proportionProducts": "Product A, Product B",

  "masterStyle": "Master Style",

  "cannotReturn": "No",

  "greatFind": "Yes",

  "webExclusive": "Yes",

  "nyDeals": "Yes",

  "promoTagline": "Special Offer",

  "partiallyPromoted": "No",

  "productCategory": "Category A, Category B",

  "sortOrder": "1",

  "quantitySold": 100,

  "averageRating": 4.5

}

 \
Response:



* Status Code: 200 OK
* Body: "Product Created"


### **Read Product**

Retrieve a product by its ID.

URL: /api/v1/product/{productId}

Method: GET

Path Parameters:



* productId (required): The ID of the product to retrieve.

Response:



* Status Code: 200 OK
* Body: Product object


### **Update Product**

Update an existing product.

URL: /api/v1/product

Method: PUT

Request Body:

{

  "id": 1,

  "name": "Updated Product Name",

  "description": "Updated Product Description"

}

Response:



* Status Code: 200 OK
* Body: "Product Updated"


### **Delete Product**

Delete a product by its ID.

URL: /api/v1/product/{productId}

Method: DELETE

Path Parameters:



* productId (required): The ID of the product to delete.

Response:



* Status Code: 200 OK
* Body: "Product Deleted"
