const Page = require('./page');


class modalConfirmPage extends Page {
  

    get titleConfirm () {
        return $("//div[@class='sweet-alert  showSweetAlert visible']/child::h2");
    }

    
    get textConfirm () {
        return $("//p[@class='lead text-muted ']");
    }

    
    get btnConfirm () {
        return $("//button[@class='confirm btn btn-lg btn-primary']");
      
    }


    clicktoConfirmOK(){
       super.clicktoBtn(this.btnConfirm);
    }

    getTitleConfirm(){
        return this.titleConfirm.getText()
    }

    getTextConfirm(){
        return this.textConfirm.getText()
    }

   
  
}

module.exports = new modalConfirmPage();
