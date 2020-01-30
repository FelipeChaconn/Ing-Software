<?php

namespace App\Http\Controllers;

use App;
use Carbon\Traits\Timestamp;
use Illuminate\Http\Request;

class CategoryController extends Controller
{
   /**
     * Display a listing of the users
     *
     * @param  \App\Category 
     * @return \Illuminate\View\View
     */
    public function index()
    {
         $categories = App\Category::paginate(15);
        return view('pages.categories.index',compact('categories'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('pages.categories.create');
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
       // return $request->all();
        $newCategory = new App\Category();
        $newCategory->name =  $request->name;
        $newCategory->detail =  $request->detail;
        $newCategory->save();
        return redirect()->route('category-list')->withStatus(__('Category successfully added.'));
        
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function show(Category $category)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $category = App\Category::findOrFail($id);
        return view('pages.categories.edit',compact('category'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $categoryUpdate = App\Category::findOrFail($id);
        $categoryUpdate->name = $request->name;
        $categoryUpdate->detail = $request->detail;
        $categoryUpdate->save();
        return redirect()->route('category-list')->withStatus(__('Category successfully updated'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Category  $category
     * @return \Illuminate\Http\RedirectResponse
     */
    public function destroy(Request $request ,$id)
    {
        $categoryDelete = App\Category::findOrFail($id);
        $categoryDelete->delete();
        return redirect()->route('category-list')->withStatus(__('Category successfully deleted.'));
    }
}
