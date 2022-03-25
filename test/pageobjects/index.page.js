

const Page = require('./page');


class indexPage extends Page {
  

    get btnLaptops () {
        return $("//a[contains(text(),'Laptops')]");
    }


    clicktoLaptop(){
       super.clicktoBtn(this.btnLaptops);
    }

   
    openDemozableSite() {
        return super.open('/');
    }
}

module.exports = new indexPage();
