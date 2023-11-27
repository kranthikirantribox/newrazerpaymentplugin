declare module "@capacitor/core"{
  interface registerPlugin{
    RazerPaymentPlugin : RazerPaymentPlugin;
  }
}

export interface RazerPaymentPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  start(options: { value: string }): Promise<{ value: string }>;
  status(options: { value: string }): Promise<{ value: string }>;
}
