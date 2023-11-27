import { registerPlugin } from '@capacitor/core';
const RazerPayment = registerPlugin('RazerPayment', {
    web: () => import('./web').then(m => new m.RazerPaymentWeb()),
});
export * from './definitions';
export { RazerPayment };
//# sourceMappingURL=index.js.map