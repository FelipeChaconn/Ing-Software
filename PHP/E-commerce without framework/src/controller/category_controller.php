<?php
include 'src/model/sql_category.php';
class Category extends sql_category
{
    private $id;


    /**
     * GET on specific category from the database
     *
     * @id Id of the Category
     */
    public function getCategory($id)
    {
        $query = $this->connect()->prepare('SELECT * FROM category WHERE id = :id');
        $query->execute(['id' => $id]);

        foreach ($query as $currentCategory) {
            $this->userId = $currentCategory['id'];
            $this->category = $currentCategory['name'];
        }
        return $id;
    }



    /**
     * Show all category from AdminCategoryVies
     *
     * 
     */
    public function setCategoryInTable()
    {
        $query = $this->connect()->prepare('SELECT * FROM category');
        $query->execute();
        if ($query->rowCount() != 0) {
            while ($row = $query->fetch()) {
                echo "<tr>" .
                    "<td>" . $row["id"] . "</td>" .
                    "<td>" . $row["name"] . "</td>" .
                    " <td>	
                    <a class='edit'  href='?a=adminCategories_view&id=".$row['id']."' value='edit' title='Edit'  data-id='".$row["id"]."'><i class='fa fa-edit'></i></a>
                    <form method='POST' >
                    <input type='hidden' name='id_DeleteCat' value='".$row['id']."'>
                    <button sclass='btn btn-danger'  type= 'submit'> 
                        <i class='far fa-trash-alt'></i>
                    </button>
                    </form>
                   
                 
                </td>";
                "</tr>";
            }
        } else {
            echo "Don't exist records for list on the table";
        }
    }
     /**
     * Show all category in Select (Products)
     *
     * 
     */
    public function setCategoryInSelect()
    {
        $query = $this->connect()->prepare('SELECT * FROM category');
        $query->execute();
        if ($query->rowCount() != 0) {
            while ($row = $query->fetch()) {
               $category_id= $row['id'];
               $category_name= $row['name'];
                echo "<option value=\"".$category_id."\" >$category_name </option>";
            }
        } else {
            echo "Don't exist records for list on the table";
        }
    }

    public function setCatInView(){
        $query = $this->connect()->prepare('SELECT * FROM category');
        $query->execute();
        if ($query->rowCount() != 0) {
            while ($row = $query->fetch()) {
               $category_id= $row['id'];
               $category_name= $row['name'];
               echo "<option  value=\"".$row['id']."\" >$category_name </option>";
            }
        } else {
            echo "<option  value= 0 >Category not availble </option>";
        }
       
    }

    /**
     * Insert on specific category from the database
     *
     * @nameCategory Name category of the Category
     */
    public function insertCategory($nameCategory)
    {
        $query = $this->connect()->prepare("INSERT INTO  category (name) VALUES (?)");
        $query->execute([$nameCategory]);
    }



    /**
     * Delete on specific category from the database
     *
     * @id Id of the categpry
     */
    public function deleteCategory($id)
    {
        
            $query = $this->connect()->prepare('DELETE FROM category
            WHERE id = :id');
            $query->execute(['id' => $id]);
            
    }



    /**
     * Update on specific category from the database
     *
     * @id Id of the categpry
     */
    public function UpdateCategory($id)
    { 



    }



    public function getCategoryID()
    {
        return $this->id;
    }
}
