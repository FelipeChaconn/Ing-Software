<main>
  <div>
    <h1 class="col-xs-8  text-center title">Clients</h1>
  </div>

  <table  class="table  table-responsive-sm table-striped"  >
    <thead>
      <tr>
        <td>Id Number</td>
        <td>Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Telephone</td>
        <td>Direction</td>
      </tr>
    </thead>
    <tbody>
      <?php
      $userClientValue =2;
      $user->setClientsInTable($userClientValue);
      ?>
    </tbody>
  </table>
</main>