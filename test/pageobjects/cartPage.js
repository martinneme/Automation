

const Page = require('./page');


class navPage extends Page {
  

    get nameProd () {
        return $("//tr[@class='success']/td[2]");
    }
    get priceProd () {
        return $("//tr[@class='success']/td[3]");
    }
    get btnPlaceOrder () {
        return $("//button[contains(text(),'Place Order')]");
    }


    clicktoPlaceOrder(){
       super.clicktoBtn(this.btnPlaceOrder);
    }

    getNameProd(){
        return this.nameProd.getText();
    }

    getPriceProd(){
        return this.priceProd.getText();
    }





   
  
}

module.exports = new navPage();
