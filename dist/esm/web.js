import { WebPlugin } from '@capacitor/core';
export class RazerPaymentWeb extends WebPlugin {
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
//# sourceMappingURL=web.js.map