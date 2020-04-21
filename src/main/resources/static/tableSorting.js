function tableSortFilterClicked() {
    var sorttype = $("#sortSelect").val();

    if(sorttype == "id") {
        console.log("Sorting by ID")
    }
    else if(sorttype == "title") {
        console.log("Sorting by Title")
    }
    else if(sorttype == "date") {
        console.log("Sorting by Date")
    }
    else if(sorttype == "severity") {
        console.log("Sorting by Severity")
    }
    else if(sorttype == "priority") {
        console.log("Sorting by Priority")
    }
    else {
        console.log("No Filter selected")
    }
}

function sortById() {}
function sortByTitle() {}
function sortByDate() {}
function sortBySeverity() {}
function sortByPriority() {}
