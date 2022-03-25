const Page = require('./page');


class productPage extends Page {


    get nameProd() {
        return $("h2[class='name']");
    }

    get priceProd() {
        return $("h3[class='price-container']");
    }

    get btnAddToCart() {
        return $("a[onclick*='addToCart']");
    }


    clickToAddToCart() {
        super.clicktoBtn(this.btnAddToCart);
    }


    getNameProd() {
        return this.nameProd.getText()
    }

    async getPriceProd() {
        const price = await this.priceProd.getText();
        const start = price.indexOf("$");
        const end = price.indexOf(" ");
        return price.substring(start+1, end);



    }

}

module.exports = new productPage();