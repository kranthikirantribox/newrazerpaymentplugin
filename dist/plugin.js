var capacitorRazerPayment = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
