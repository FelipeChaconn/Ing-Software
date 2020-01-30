<?php
 class STUDENTS extends CI_Controller
 {

    public function index()
    {
        $data['title'] = ' Students Enrolled';
        $data['students'] = $this->student_model->get_students();
        $this->load->view('templates/header');
        $this->load->view('students/index', $data);
        $this->load->view('templates/footer');
    }
    
 }