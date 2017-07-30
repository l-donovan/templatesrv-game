function getDaysInMonth(i) {
	return [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][(12 + (i % 12)) % 12];
}

function fillCalendar(id, date) {
	date = date || new Date();
	var calendar  = document.getElementById(id);
	var thisYear  = date.getYear() + 1900;
	var thisMonth = date.getMonth();
	var months    = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

	calendar.innerHTML = 
		"<tr><th id=\"calendar-header\" colspan=7>" +
			"<a id=\"calendar-prev\" onclick=\"fillCalendar('" + id + "', new Date(" + thisYear + ", " + (thisMonth - 1) + "))\">&#8592;</a>" +
			"&nbsp;" + months[thisMonth].slice(0, 3) + " " + thisYear + "&nbsp;" + 
			"<a id=\"calendar-next\" onclick=\"fillCalendar('" + id + "', new Date(" + thisYear + ", " + (thisMonth + 1) + "))\">&#8594;</a>" +
		"</th></tr>";

	function addRow(l, q) {
		if (typeof q == "string") q = Array(l.length).fill(q);
		var row = calendar.insertRow(-1);
		for (var i = 0; i < l.length; i++) {
			var cell = row.insertCell(i);
			cell.className = "calendar-cell";
			cell.innerHTML = "<a class=\"calendar-link " + q[i] + "\" href=\"/date/" + ("0000" + thisYear).slice(-4) + ("00" + (thisMonth + 1)).slice(-2) + ("00" + l[i]).slice(-2) + "\">" + l[i] + "</a>";
		}
	}

	addRow("SMTWTFS".split(''), "calendar-month-header");

	var dates = [];
	var styles = [];
	var j = new Date(thisYear, thisMonth).getDay();
	var b = getDaysInMonth(thisMonth - 1) + 1;
	for (var i = 0; i < j; i++) {
		dates.push(b - j + i);
		styles.push("calendar-month-prev");
	}
	for (var i = 1; i < getDaysInMonth(thisMonth) + 1; i++) {
		dates.push(i);
		styles.push("calendar-month-current");
		j += 1;
		if (j > 6) {
			addRow(dates, styles);
			dates = [];
			styles = [];
			j = 0;
		}
		if (i == getDaysInMonth(thisMonth)) {
			for (var k = 1; k < 8 - j; k++) {
				dates.push(k);
				styles.push("calendar-month-next");
			}
			addRow(dates, styles);
		}
	}
}