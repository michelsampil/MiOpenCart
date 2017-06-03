<?php

namespace tests\api;

use ApiTester;
use Codeception\Util\HttpCode;

class ProductosCest {

    public function _before(ApiTester $I) {
        
    }

    public function _after(ApiTester $I) {
        
    }

    public function buscarProducto(ApiTester $I) {
        $I->wantTo('Buscar un iPhone');
        $I->sendGET('?route=product/search&search=iphone');
        $I->seeResponseCodeIs(HttpCode::OK);
//        $I->seeResponseIsJson();
        $I->seeResponseContains('image/cache/catalog/demo/iphone_1-228x228.jpg');
    }

    public function consultarPrecio(ApiTester $I) {
        $I->wantTo('Consultar un precio');
        $I->sendGET('?route=product/product&product_id=41');
        $I->seeResponseCodeIs(HttpCode::OK);
//        $I->seeResponseIsJson();
        $I->seeResponseContains('$122.00');
    }

}
