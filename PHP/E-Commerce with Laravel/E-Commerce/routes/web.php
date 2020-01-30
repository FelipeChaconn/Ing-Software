<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;

Route::get('/', function () {
	return view('welcome');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home')->middleware('auth');

Route::get('admin/home', 'HomeController@adminHome')->name('admin.home')->middleware('is_admin');

Route::group(['middleware' => 'is_admin'], function () {
	Route::get('/', 'HomeController@adminHome');
	//Routes Products
	Route::get('admin/products', 'ProductController@index')->name('product-list');
	
	Route::get('admin/product/add', 'ProductController@create')->name('product-add');
	Route::get('admin/product/edit/{id}', 'ProductController@edit')->name('product-edit');
	Route::post('/store', 'ProductController@store')->name('product-store');
	Route::put('admin/product/edit/{id}', 'ProductController@update')->name('product-update');	
	Route::delete('admin/product/delete/{id}', 'ProductController@destroy')->name('product-destroy');

	//Routes Category
	Route::get('admin/category/list', 'CategoryController@index')->name('category-list');
	Route::get('admin/category/add', 'CategoryController@create')->name('category-add');
	Route::get('admin/category/edit/{id}', 'CategoryController@edit')->name('category-edit');
	Route::post('/', 'CategoryController@store')->name('category-store');
	Route::put('admin/category/edit/{id}', 'CategoryController@update')->name('category-update');
	Route::delete('admin/category/delete/{id}', 'CategoryController@destroy')->name('category-destroy');
	
});


Route::group(['middleware' => 'auth'], function () {
	Route::get('products', 'ProductController@list')->name('table');
	Route::get('products/{id}', 'ProductController@listProduct')->name('see-details');

	Route::get('cart/{id}', 'ProductController@addToCart')->name('cart');
	Route::get('cart/', 'ProductController@cart')->name('cartShow');
	Route::patch('update-cart', 'ProductController@updateCart');
	 
	Route::delete('remove-from-cart', 'ProductController@remove');

	Route::get('typography', function () {
		return view('pages.typography');
	})->name('typography');

	Route::get('icons', function () {
		return view('pages.icons');
	})->name('icons');

	Route::get('map', function () {
		return view('pages.map');
	})->name('map');

	Route::get('notifications', function () {
		return view('pages.notifications');
	})->name('notifications');

	Route::get('rtl-support', function () {
		return view('pages.language');
	})->name('language');

	Route::get('upgrade', function () {
		return view('pages.upgrade');
	})->name('upgrade');
});

Route::group(['middleware' => 'auth'], function () {
	Route::resource('user', 'UserController', ['except' => ['show']]);
	Route::get('profile', ['as' => 'profile.edit', 'uses' => 'ProfileController@edit']);
	Route::put('profile', ['as' => 'profile.update', 'uses' => 'ProfileController@update']);
	Route::put('profile/password', ['as' => 'profile.password', 'uses' => 'ProfileController@password']);
});
