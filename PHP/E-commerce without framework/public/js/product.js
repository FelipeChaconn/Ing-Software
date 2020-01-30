$('#spinner').on('input',function(e){
        $('#quantity').html($(this).val())

})
$('#titleName').on('input',function(e){
    $('#TitleNameShow').html($(this).val())

})

$('#priceInput').on('input',function(e){
    $('#priceShow').html($(this).val())

})
$('#descInput').on('input',function(e){
    $('#descShow').html($(this).val())
    

})
$('#imgInput').on('input',function(e){
    debugger;
    var selectedFile = $('#imgInput').val();
    $('#imgShow').attr("src", selectedFile);
    

})