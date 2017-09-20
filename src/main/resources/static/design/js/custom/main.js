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
  $("#expenseForm .form-group.date").datepicker({
    maxViewMode: 2,
    todayBtn: true,
    clearBtn: true
  });
  $("#isExpense").click(function(e) {
    e.preventDefault();
    $(".category-group")
      .children(".btn-primary")
      .show();
    $(".category-group")
      .children(".btn-success")
      .hide();
  });
  $("#isIncome").click(function(e) {
    e.preventDefault();
    $(".category-group")
      .children(".btn-success")
      .show();
    $(".category-group")
      .children(".btn-primary")
      .hide();
  });

  var comments = new Bloodhound({
    datumTokenizer: Bloodhound.tokenizers.obj.whitespace("name"),
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    prefetch: {
      url: "/budgetKeeper/entry/comments",
      filter: function(list) {
        return $.map(list, function(comment) {
          return { name: comment };
        });
      }
    }
  });
  comments.initialize();

  $(".bootstrap-tagsinput").tagsinput({
    typeaheadjs: {
      name: "comments",
      displayKey: "name",
      valueKey: "name",
      source: comments.ttAdapter()
    }
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
        var btnColor = "btn-primary";
        if (result[i].type == 1) {
          btnColor = "btn-success";
        }
        var catBtn = $("<label/>", {
          class: "btn " + btnColor
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
