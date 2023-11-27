import { registerPlugin } from '@capacitor/core';

import type { RazerPaymentPlugin } from './definitions';

const RazerPayment = registerPlugin<RazerPaymentPlugin>('RazerPayment', {
  web: () => import('./web').then(m => new m.RazerPaymentWeb()),
});

export * from './definitions';
export { RazerPayment };
