/**
 * 
 */
/*
 * ! jQuery v1.11.1 | (c) 2005, 2014 jQuery Foundation, Inc. |
 * jquery.org/license
 */
function setActiveLink(setActive) {
	var links = document.querySelectorAll("#menuLinks li");
	Array.prototype.map.call(links, function(e) {
		e.className = "";
		if (e.id == setActive)
			e.className = 'active';
	})
}