import { WebPlugin } from '@capacitor/core';

import type { RazerPaymentPlugin } from './definitions';

export class RazerPaymentWeb extends WebPlugin implements RazerPaymentPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async start(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async status(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
