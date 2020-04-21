// variable to create a map of priority levels to compare
let priorityMap = new Map([["LOW", 0], ["MEDIUM", 1], ["HIGH", 3]]);

// funcion to get the value selected from the user
function tableSortFilterClicked() {
    var sorttype = $("#sortSelect").val();

    if(sorttype == "id") {
        sortColumn(0);
    }
    else if(sorttype == "title") {
        sortColumn(1)
    }
    else if(sorttype == "date") {
        sortColumn(2)
    }
    else if(sorttype == "severity") {
        sortColumn(3)
    }
    else if(sorttype == "priority") {
        sortColumn(4)
    }
}


// sort the given column by its index
function sortColumn(column) {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("bugTable");
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */

    while (switching) {
        // Start by saying: no switching is done:
        switching = false;

        // get the rows from the table
        rows = table.rows;

        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {

            // Start by saying there should be no switching:
            shouldSwitch = false;

            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[column];
            y = rows[i + 1].getElementsByTagName("TD")[column];

            /* Based on the column working on, validate
            whether the a switch should happen by comparing
            the two columns x and y */
            switch (column) {
                case 0 :
                    shouldSwitch = validateForId(x, y);
                    break;
                case 1 :
                    shouldSwitch = validateForTitle(x, y);
                    break;
                case 2 :
                    shouldSwitch = validateForDate(x, y);
                    break;
                case 3 :
                    shouldSwitch = validateForSeverity(x, y);
                    break;
                case 4 :
                    shouldSwitch = validateForPriority(x, y);
                    break;
                default: break;
            }
            if(shouldSwitch) {
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

/**
 * functions to sort columns based on column data type
 */

// id is sorted smallest to biggest (or oldest to newest)
function validateForId(x, y) {
    if (Number(x.innerHTML) > Number(y.innerHTML)) {
        // If so, mark as a switch and break the loop:
        return true;
    }
    return false;
}

// title is sorted in alphabetical order
function validateForTitle(x, y) {
    if(x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        return true;
    }
    return false;
}

// date is sorted by oldest to newest
function validateForDate(x, y) {
    if(Date.parse(x.innerHTML) > Date.parse(y.innerHTML)) {
        return true;
    }
    return false;
}

// severity is sorted 1 -> 5 (most severe to least severe)
function validateForSeverity(x, y) {
    if(Number(x.innerHTML) > Number(y.innerHTML)) {
        return true;
    }
    return false;
}

// priority is sorted from high to low
function validateForPriority(x, y) {
    if(priorityMap.get(x.innerHTML) < priorityMap.get(y.innerHTML)) {
        return true;
    }
    return false;
}