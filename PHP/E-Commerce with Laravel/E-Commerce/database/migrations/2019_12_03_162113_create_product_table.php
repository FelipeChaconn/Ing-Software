<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateProductTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('product', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->string('SKU')->unique();
            $table->string('name_p');
            $table->string('desc_p');
            $table->string('img_p');
            $table->integer('price_p');
            $table->integer('stock_p');
            $table->unsignedBigInteger('category_id');
           
            $table->timestamps();

            $table->foreign('category_id')
            ->references('id')->on('category')
            ->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('product');
    }
}
