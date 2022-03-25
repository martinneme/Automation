const Page = require('./page');


class modalOrderPage extends Page {


    get name() {
        return $("//input[@id='name']");
    }
    get country() {
        return $("//input[@id='country']");
    }
    get city() {
        return $("//input[@id='city']");
    }

    get creditCard() {
        return $("//input[@id='card']");
    }

    get month() {
        return $("//input[@id='month']");
    }

    get year() {
        return $("//input[@id='year']");
    }

    get btnPurchase() {
        return $("//button[@onclick='purchaseOrder()']");
    }

    async clicktoPurchase() {
       
        super.clicktoBtn(this.btnPurchase);
        console.log("click purchase");
    }

    async formOrderComplete(name, country, city, creditCard, month, year) {
        
        (await this.name).waitForDisplayed();
        this.name.setValue(name);
        this.country.setValue(country)
        this.city.setValue(city);
        this.creditCard.setValue(creditCard);
        this.month.setValue(month);
        this.year.setValue(year);

         await this.clicktoPurchase();

    }

}

module.exports = new modalOrderPage();