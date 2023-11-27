import { WebPlugin } from '@capacitor/core';
import type { RazerPaymentPlugin } from './definitions';
export declare class RazerPaymentWeb extends WebPlugin implements RazerPaymentPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    start(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    status(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
