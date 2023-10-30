function Delete(id){
    var confirmationBox = document.getElementById("confirmationBox");
      confirmationBox.style.display = "block";
      $('.confirmDelete').click(function(){
        urll="http://localhost:8081/deletedSimple/"+id
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
  function Update(id){
    var editModal = document.getElementById("editModal");
    editModal.style.display="block";
    $('.update').click(function(){
        var label = document.getElementById('editName').value;
        var inputElement = document.getElementById("editImage");
        var selectedFile = inputElement.value;
        var image = selectedFile.replace();
        if(label == '' || image == ''){
            alert('Không có dữ liệu ảnh hoặc nhãn');
        } else {
            urll = "http://localhost:8081/bt2/" + id;
            dataS = {
                "name": label,
                "image": image
            };
            $.ajax({
              type: "PUT",
              url: urll,
              data: JSON.stringify(dataS),
              contentType: "application/json",
              success: function() {
                  // Success callback code
                  closeEditModal();
                  location.reload();
              },
          });
          
        }
     });
    $('.cancelUpdate').click(function(){
        closeEditModal();
      })
  }
  function closeEditModal() {
      var editModal = document.getElementById("editModal");
      editModal.style.display = "none";
  }
  function CreateSimple(){
    var createModal = document.getElementById("createModal");
    createModal.style.display="block";
    $('.create').click(function(){
      var label = document.getElementById('createName').value;
      var inputElement = document.getElementById("createImage");
      var selectedFile = inputElement.value;
      var image = selectedFile.replace();
      if(label == '' || image == ''){
          alert('Không có dữ liệu ảnh hoặc nhãn');
      } else {
          dataS = {
              "name": label,
              "image": image
          };
          $.ajax({
              type: "POST",
              url: "http://localhost:8081/bt2",
              data: JSON.stringify(dataS),
              contentType: "application/json",
              success: function() {
                  closeEditModal();
                  location.reload();
              },
              
          });
      }
    });
    $('.cancelCreate').click(function(){
        closeCreateModal();
      })
  }
  function closeCreateModal() {
      var editModal = document.getElementById("createModal");
      editModal.style.display = "none";
  }
  function MySearch(){
      var inputSearch = document.getElementById('search_txt').value;
      ob={
          "name":inputSearch
      }
      $("#data").empty();
      $.ajax({
          type: "GET",
          url: "http://localhost:8081/Search",
          data: ob,
          dataType: "json",
          success: function (data) {
              $.each(data.listSimple, function (i, item) {
                  var row = "<tr>";
                  row += "<td>" + new Date(item.date).toDateString() + "</td>";
                  row += "<td>" + item.name + "</td>";
                  row += "<td><img src='" + item.image + "'></td>";
                  row += "<td style='display:flex;padding-left: 35%;'><p onclick='Update(" + item.id + ")' class='action-buttons'>Sửa</p><p>/</p>"
                      + "<p onclick='Delete(" + item.id + ")' class='action-buttons'>Xóa</p></td>";
                  row += "</tr>";
                  $('.List_Simple ').append(row);
              });
          }
      });
      var NonePage =document.getElementById("conten");
      NonePage.style.display="none";
  }