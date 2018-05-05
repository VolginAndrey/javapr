		document.li.onmouseover = document.li.onmouseout = handler;
		function handler(event) {
			function str(el) {
    		if (!el) return "null"
    		return el.className || el.tagName;
  }

  li.value += event.type + ': ' +
    'target=' + str(event.target) +
    ', relatedTarget=' + str(event.relatedTarget) + "\n";
  li.scrollTop = li.scrollHeight;

  if (event.type == 'mouseover') {
    event.target.style.background = 'pink'
  }
  if (event.type == 'mouseout') {
    event.target.style.background = ''
  }
}