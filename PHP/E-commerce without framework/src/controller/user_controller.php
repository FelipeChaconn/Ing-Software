<?php
include 'src/model/sql_connection.php';
class User extends sql_connection
{
    private $name;
    private $userId;
    //Get User by ID
    public function getUser($id)
    {
        $query = $this->connect()->prepare('SELECT * FROM user WHERE id = :id');
        $query->execute(['id' => $id]);

        foreach ($query as $currentUser) {
            $this->role_user = $currentUser['id_role'];
            $this->userId = $currentUser['id'];
            $this->name = $currentUser['name'];
        }
        return $id;
    }

    //SET USER IN SESSION
    public function setUser($id)
    {
        $query = $this->connect()->prepare('SELECT * FROM user WHERE id = :id');
        $query->execute(['id' => $id]);

        foreach ($query as $currentUser) {
            $this->role_user = $currentUser['id_role'];
            $this->userId = $currentUser['id'];
            $this->name = $currentUser['name'];
        }
    }

    //Check if User Exist
    public function userExists($id, $pass)
    {
        $md5pass = md5($pass);
        $query = $this->connect()->prepare('SELECT * FROM user WHERE id = :id AND password = :pass');
        $query->execute(['id' => $id, 'pass' => $md5pass]);
        if ($query->rowCount()) {
            return true;
        } else {
            return false;
        }
    }
    //Check if User Exist by ID
    public function userExistsByID($id)
    {
        $query = $this->connect()->prepare('SELECT * FROM user WHERE id = :id ');
        $query->execute(['id' => $id]);
        if ($query->rowCount()) {
            return true;
        } else {
            return false;
        }
    }
    //ADD User to BD
    public function addUser($idUser, $nameUser, $lastNameUser, $passUser, $telNumberUser, $dirUser, $emailUser, $role)
    {
        $md5pass = md5($passUser);
        $query = $this->connect()->prepare("INSERT INTO  user (id,name,last_name,password,tel_number,direction,email,id_role) VALUES  (?,?,?,?,?,?,?,?)");
        $query->execute([$idUser, $nameUser, $lastNameUser, $md5pass, $telNumberUser, $dirUser, $emailUser, $role]);
    }


    public function setClientsInTable($id)
    {
        $query = $this->connect()->prepare('SELECT id,name,last_name,email,tel_number,direction FROM user WHERE id_role = :client_id');
        $query->execute(['client_id' => $id]);

        if ($query->rowCount() != 0) {
            while ($row = $query->fetch()) {
                echo "<tr>" .
                    "<td>" . $row["id"] . "</td>" .
                    "<td>" . $row["name"] . "</td>" .
                    "<td>" . $row["last_name"] . "</td>" .
                    "<td>" . $row["email"] . "</td>" .
                    "<td>" . $row["tel_number"] . "</td>" .
                    "<td>" . $row["direction"] . "</td>" .
                    "</tr>";
            }
        } else {
            echo "Don't exist records for list on the table";
        }

        
    }
    public function clientsRowCount($id)
    {
        $number_of_rows = 0;
        $query =  $this->connect()->prepare('SELECT * FROM user WHERE id_role = :client_id');
        $query->execute(['client_id' => $id]);
        if ($query->rowCount()) {
            $number_of_rows = $query->rowCount();
        } else {
            echo "fallo";
        }

        return $number_of_rows;
    }

    public function getUserRole()
    {
        return $this->role_user;
    }
    public function getName()
    {
        return $this->name;
    }
}
