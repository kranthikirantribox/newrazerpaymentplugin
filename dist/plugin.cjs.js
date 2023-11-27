'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const RazerPayment = core.registerPlugin('RazerPayment', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.RazerPaymentWeb()),
});

class RazerPaymentWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async start(options) {
        console.log('ECHO', options);
        return options;
    }
    async status(options) {
        console.log('ECHO', options);
        return options;
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    RazerPaymentWeb: RazerPaymentWeb
});

exports.RazerPayment = RazerPayment;
//# sourceMappingURL=plugin.cjs.js.map
