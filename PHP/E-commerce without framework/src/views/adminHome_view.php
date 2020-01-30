
  <main>
    <div>
      <h1 class="col-xs-8  text-center title">Dashboard</h1>
    </div>
    <div class="card-deck">
      <div class="card border-success">
        <div class="title card-header">Sales</div>
        <div class="card-body text-success">
          <h5 class="card-title"><?php ?> sales made</h5>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
      </div>
      <div class="card border-primary">
        <div class="title card-header">Clients</div>
        <div class="card-body text-primary">
          <h5 class="card-title"><?php echo $user->clientsRowCount(2); ?> users registered</h5>
          <p class="card-text"><small class="text-muted"> Last updated <?php date("F d Y H:i:s.", getlastmod()); ?></small></p>

        </div>
      </div>
      <div class="card border-warning">
        <div class="title card-header">Sales Total Amount</div>
        <div class="card-body text-warning">
          <h5 class="card-title">$2450</h5>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>

        </div>
      </div>
    </div>
  </main>