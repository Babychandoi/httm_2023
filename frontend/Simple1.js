function Delete(id){
    var confirmationBox = document.getElementById("confirmationBox");
      confirmationBox.style.display = "block";
      $('.confirmDelete').click(function(){
        urll="http://localhost:8081/bt1/"+id
        $.ajax({
            type: "DELETE",
            url: urll,
        })
        alert("Đã xoá!");
        closeConfirmationBox();
        location.reload();
      })
      $('.cancelDelete').click(function(){
        closeConfirmationBox();
      })      
  }
  function closeConfirmationBox() {
      var confirmationBox = document.getElementById("confirmationBox");
      confirmationBox.style.display = "none";
  }
  function xemchitiet(id,imagee) {
    var imgElement = document.getElementById("myImage");
    var imageUrl = imagee; 

    imgElement.src = imageUrl;
    var ctSimple= document.getElementById("chitietModal");
        ctSimple.style.display = "flex";
        $("#data_ct").empty();
    url = "http://localhost:8081/bt1/" + id; 
    $.ajax({
      type: "GET",
      url: url,
      dataType: "json",
      success: function (data) {
  
        $.each(data.listCoor, function (i, item) {
          var row = "<tr>";
          row += "<td>" + new Date(item.date).toDateString() + "</td>";
          row += "<td>" + item.x_min + "</td>";
          row += "<td>" + item.y_min + "</td>";
          row += "<td>" + item.x_max + "</td>";
          row += "<td>" + item.y_max + "</td>";
          row += "</tr>";
          $('.tbl_ct').append(row);
        });
      }
    });
    $('.cancel_ct').click(function(){
      closeCT();
    })      
  }
  function closeCT() {
    var ctSimple= document.getElementById("chitietModal");
    ctSimple.style.display = "none";
}