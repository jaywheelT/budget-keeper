$(document).ready(function () {
  formCategories();
  $(".addCatBtn").click(function (e) {
    e.preventDefault();
    $.ajax({
      url: "/budgetKeeper/category",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify($("#catgoryForm").serializeJSON()),
      success: function () {
        formCategories();
      }
    });
  });
  $(".addEntryBtn").click(function (e) {
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
      success: function (result) {
        console.log(result);
      }
    });
  });
  $("#expenseForm .form-group.date").datepicker({
    maxViewMode: 2,
    todayBtn: true,
    clearBtn: true
  });
  $("#isExpense").click(function (e) {
    e.preventDefault();
    $(".category-group")
      .children(".btn-primary")
      .show();
    $(".category-group")
      .children(".btn-success")
      .hide();
  });
  $("#isIncome").click(function (e) {
    e.preventDefault();
    $(".category-group")
      .children(".btn-success")
      .show();
    $(".category-group")
      .children(".btn-primary")
      .hide();
  });

  initTagsInpt();
});

function formCategories() {
  $.ajax({
    url: "/budgetKeeper/category",
    dataType: "json",
    success: function (result) {
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

      $("input[type=radio][name=categoryId]").change(function () {
        initTagsInpt(this.value);
      });
    }
  });

}

function initTagsInpt(categoryId) {
  var url = "/budgetKeeper/entry/comments";
  if (categoryId != undefined) {
    url = url + "/" + categoryId;
  }
  var commentsData;
  $.ajax({
    url: url,
    contentType: "application/json",
    success: function (result) {
      commentsData = result;
      var comments = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local: commentsData
      });
      comments.initialize();

      $(".bootstrap-tagsinput").tagsinput({
        maxTags: 1,
        typeaheadjs: {
          name: "comments",
          source: comments.ttAdapter()
        }
      });
    }
  });
}