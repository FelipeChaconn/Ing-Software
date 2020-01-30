<h2><?= $title ?></h2>
    <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">identity</th>
      <th scope="col">name</th>
      <th scope="col">Year</th>
    </tr>
  </thead>
  <tbody>
  <?php foreach ($students as $student): ?>
    <tr">
      <td><?php echo $student['id'];?></td>
      <td><?php  echo $student['id_identify'];?></td>
      <td><?php  echo $student['name'];?></td>
      <td><?php  echo $student['year_enrolled'];?></td>
    </tr>
 
<?php endforeach;?>
</tbody>
</table> 