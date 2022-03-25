const { numberOfWindowsToBe, alertIsPresent } = require('wdio-wait-for');
const cartPage = require('../pageobjects/cartPage');
const indexPage = require('../pageobjects/index.page');
const modalConfirmPage = require('../pageobjects/modalConfirmPage');
const modalOrderPage = require('../pageobjects/modalOrderPage');
const navPage = require('../pageobjects/navPage');
const productPage = require('../pageobjects/productPage');
const ProductsAllPage = require('../pageobjects/ProductsAllPage');


describe('Demozable site', () => {
    it('Buy product Demozable site', async () => {
         indexPage.openDemozableSite();
          indexPage.clicktoLaptop();
        
        ProductsAllPage.clicktoProd();

        const nameprod = await productPage.getNameProd();
        const priceprod = await productPage.getPriceProd();
        expect(nameprod).toEqual("Sony vaio i5");
        expect(priceprod).toEqual("790");

        productPage.clickToAddToCart();
        expect(await browser.waitUntil(alertIsPresent()));
        await browser.acceptAlert();
        


        navPage.clicktoNavCart();
        const cartNameProd= await cartPage.getNameProd()
        const cartPriceProd= await cartPage.getPriceProd()

        expect(nameprod).toEqual(cartNameProd);
        expect(priceprod).toEqual(cartPriceProd);


        cartPage.clicktoPlaceOrder();
     

         await modalOrderPage.formOrderComplete("Martin","Argentina","Avellaneda","123456789","08","2024");
         modalOrderPage.clicktoPurchase();
        
      expect(await modalConfirmPage.getTitleConfirm()).toEqual("Thank you for your purchase!");
          const textConfirm = await modalConfirmPage.getTextConfirm();
          expect(textConfirm.includes(cartNameProd));
          expect(textConfirm).toContain("790");
          expect(textConfirm).toContain("123456789");
         
          modalConfirmPage.clicktoConfirmOK();

    });

  


});


