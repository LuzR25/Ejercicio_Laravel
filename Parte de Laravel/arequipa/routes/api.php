<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PublicacionesController;

Route::resource('publicaciones', "App\Http\Controllers\PublicacionesController");
