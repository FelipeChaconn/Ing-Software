<?php
class Student_model extends CI_Model
{
    public  function __construct()
    {
        $this->load->database();
    }
    public function get_students($id = false)
    {
        if ($id === false) {
            $query = $this->db->get('students');
            return $query->result_array();
            var_dump($query);
        }
        $query = $this->db->get_where('students', array('id' => $id));
        return $query->row_array();
    }
}
