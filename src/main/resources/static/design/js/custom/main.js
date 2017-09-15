$(document).ready(function() {
  formCategories();
  $(".addCatBtn").click(function(e) {
    e.preventDefault();
    $.ajax({
      url: "/budgetKeeper/category",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify($("#catgoryForm").serializeJSON()),
      success: function() {
        formCategories();
      }
    });
  });
  $(".addEntryBtn").click(function(e) {
    e.preventDefault();
    var entryData = $("#expenseForm").serializeJSON();
    if (entryData.hasOwnProperty("categoryId") && entryData.categoryId !== "") {
      entryData.category = {};
      entryData.category.id = entryData.categoryId;
      delete entryData.categoryId;
    }
    $.ajax({
      url: "/budgetKeeper/entry",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(entryData),
      success: function(result) {
        console.log(result);
      }
    });
  });
  $('#expenseForm .form-group.date').datepicker({
    maxViewMode: 2,
    todayBtn: true,
    clearBtn: true
  });
});

function formCategories() {
  $.ajax({
    url: "/budgetKeeper/category",
    dataType: "json",
    success: function(result) {
      var container = $(".category-group");
      container.empty();
      for (var i = 0; i < result.length; i++) {
        var catBtn = $("<label/>", {
          class: "btn btn-primary"
        })
          .append(
            $("<i/>", {
              class: result[i].icon
            })
          )
          .append(
            $("<input/>", {
              type: "radio",
              id: "categoryId",
              name: "categoryId",
              value: result[i].id
            })
          )
          .append(result[i].name);
        container.append(catBtn);
      }
    }
  });
}
