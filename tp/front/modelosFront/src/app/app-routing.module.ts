import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListadoEntradaComponent } from './listado-entrada/listado-entrada.component';
import { NuevoComponent } from './nuevo/nuevo.component'
import { ListadoSalidaComponent } from './listado-salida/listado-salida.component';

const routes: Routes = [
	{ path: 'listado', component: ListadoEntradaComponent },
	{ path: 'nuevo', component: NuevoComponent },
	{ path: 'salida', component: ListadoSalidaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
