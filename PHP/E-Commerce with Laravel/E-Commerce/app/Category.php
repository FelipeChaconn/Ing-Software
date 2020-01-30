<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
      /**
     * The table associated with the model.
     *
     * @var string
     */
    protected $table = 'category';
    public $timestamps = false;
    
    public function products(){
        //one to many relation Bd
        return $this->hasMany('App\Product');
    }


}
