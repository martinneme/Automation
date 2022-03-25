const Page = require('./page');


class navPage extends Page {
  

    get btnNavPage () {
        return $("//a[contains(text(),'Cart')]");
    }


    clicktoNavCart(){
       super.clicktoBtn(this.btnNavPage);
    }

   
  
}

module.exports = new navPage();
