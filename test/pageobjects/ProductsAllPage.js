const Page = require('./page');


class productsAllPage extends Page {
  

    get btnNotebook () {
        return $("//a[contains(text(),'Sony vaio i5')]");
    }


    clicktoProd(){
       super.clicktoBtn(this.btnNotebook);
    }

   
  
}

module.exports = new productsAllPage();
