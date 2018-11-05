import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoEntradaComponent } from './listado-entrada/listado-entrada.component';
import { HeaderComponent } from './header/header.component';
import { NuevoComponent } from './nuevo/nuevo.component';
import { ListadoSalidaComponent } from './listado-salida/listado-salida.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoEntradaComponent,
    HeaderComponent,
    NuevoComponent,
    ListadoSalidaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
