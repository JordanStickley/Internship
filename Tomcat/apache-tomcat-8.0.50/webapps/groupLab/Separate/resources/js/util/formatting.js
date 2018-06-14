(function() {

  CodeMirror.extendMode("css", {
    commentStart: "/*",
    commentEnd: "*/",
    newlineAfterToken: function(_type, content) {
      return /^[;{}]$/.test(content);
    }
  });

  CodeMirror.extendMode("javascript", {
    commentStart: "/*",
    commentEnd: "*/",
    // FIXME semicolons inside of for
    newlineAfterToken: function(_type, content, textAfter, state) {
      if (this.jsonMode) {
        return /^[\[,{]$/.test(content) || /^}/.test(textAfter);
      } else {
        if (content == ";" && state.lexical && state.lexical.type == ")") return false;
        return /^[;{}]$/.test(content) && !/^;/.test(textAfter);
      }
    }
  });

  var inlineElements = /^(a|abbr|acronym|area|base|bdo|big|br|button|caption|cite|code|col|colgroup|dd|del|dfn|em|frame|hr|iframe|img|input|ins|kbd|label|legend|link|map|object|optgroup|option|param|q|samp|script|select|small|span|strong|sub|sup|textarea|tt|var)$/;

  CodeMirror.extendMode("xml", {
    commentStart: "<!--",
    commentEnd: "-->",
    newlineAfterToken: function(type, content, textAfter, state) {
      var inline = false;
      if (this.configuration == "html")
        inline = state.context ? inlineElements.test(state.context.tagName) : false;
      return !inline && ((type == "tag" && />$/.test(content) && state.context) ||
                         /^</.test(textAfter));
    }
  });

  // Comment/uncomment the specified range
  CodeMirror.defineExtension("commentRange", function (isComment, from, to) {
    var cm = this, curMode = CodeMirror.innerMode(cm.getMode(), cm.getTokenAt(from).state).mode;
    cm.operation(function() {
      if (isComment) { // Comment range
        cm.replaceRange(curMode.commentEnd, to);
        cm.replaceRange(curMode.commentStart, from);
        if (from.line == to.line && from.ch == to.ch) // An empty comment inserted - put cursor inside
          cm.setCursor(from.line, from.ch + curMode.commentStart.length);
      } else { // Uncomment range
        var selText = cm.getRange(from, to);
        var startIndex = selText.indexOf(curMode.commentStart);
        var endIndex = selText.lastIndexOf(curMode.commentEnd);
        if (startIndex > -1 && endIndex > -1 && endIndex > startIndex) {
          // Take string till comment start
          selText = selText.substr(0, startIndex)
          // From comment start till comment end
            + selText.substring(startIndex + curMode.commentStart.length, endIndex)
          // From comment end till string end
            + selText.substr(endIndex + curMode.commentEnd.length);
        }
        cm.replaceRange(selText, from, to);
      }
    });
  });

  /*// Applies automatic mode-aware indentation to the specified range
  CodeMirror.defineExtension("autoIndentRange", function (from, to) {
    var cmInstance = this;
    this.operation(function () {
      for (var i = from.line; i <= to.line; i++) {
        cmInstance.indentLine(i, "smart");
      }
    });
  });

  // Applies automatic formatting to the specified range
  CodeMirror.defineExtension("autoFormatRange", function (from, to) {
    var cm = this;
    var outer = cm.getMode(), text = cm.getRange(from, to).split("\n");
    var state = CodeMirror.copyState(outer, cm.getTokenAt(from).state);
    var tabSize = cm.getOption("tabSize");

    var out = "", lines = 0, atSol = from.ch == 0;
    function newline() {
      out += "\n";
      atSol = true;
      ++lines;
    }

    for (var i = 0; i < text.length; ++i) {
      var stream = new CodeMirror.StringStream(text[i], tabSize);
      while (!stream.eol()) {
        var inner = CodeMirror.innerMode(outer, state);
        var style = outer.token(stream, state), cur = stream.current();
        stream.start = stream.pos;
        if (!atSol || /\S/.test(cur)) {
          out += cur;
          atSol = false;
        }
        if (!atSol && inner.mode.newlineAfterToken &&
            inner.mode.newlineAfterToken(style, cur, stream.string.slice(stream.pos) || text[i+1] || "", inner.state))
          newline();
      }
      if (!stream.pos && outer.blankLine) outer.blankLine(state);
      if (!atSol && i < text.length - 1) newline();
    }

    cm.operation(function () {
      cm.replaceRange(out, from, to);
      for (var cur = from.line + 1, end = from.line + lines; cur <= end; ++cur)
        cm.indentLine(cur, "smart");
      cm.setSelection(from, cm.getCursor(false));
    });
  });*/
	
	function applyCodeMirrorTo(textArea) {
			var _textArea = textArea;
			if (_textArea != null) {
				var cm = CodeMirror.fromTextArea(_textArea, {
					mode: "text/html",
					readOnly: true,
					theme: "default",
					autoClearEmptyLines: true,
					lineWrapping: true,
					lineNumbers: true
				});
				return cm;
			}
		}

		function getSelectedRange(editor) {
			return {
				from: editor.getCursor(true),
				to: editor.getCursor(false)
			};
		}

		function autoFormatSelection(editor) {
			var range = getSelectedRange(editor);
			//editor.autoFormatRange(range.from, range.to);
			CodeMirror.commands['goPageUp'](editor);
		}
	
	require([
	       "dojo/query",
	       "dojo/_base/array",
	       'dojo/on',
	       'dojo/dom',
	       'dojo/dom-attr',
	       'dojo/dom-geometry',
	       'dojo/dom-class',
			'dijit/registry',
			'dojo/ready',
			'bootstrap/Scrollspy',
			'bootstrap/Affix',
	        "dojo/domReady!"
	    ], function (query, array, on, dom, domAttr, domGeom, domClass, registry, ready) {
			var array_ta = query('textarea.pattern'),
				hamburgerMenu = query('.navbar-toggle')[0],
				popMenu = query('.navbar-collapse')[0];

			array.forEach(array_ta, function (item, i) {
				var editor = applyCodeMirrorTo(item);
				CodeMirror.commands["selectAll"](editor);
				autoFormatSelection(editor);
				query('#leftNav').affix()
			});

			hamburgerMenu.onclick = function () {
				popMenu.classList.toggle("show");
			}

			//ready(function () {
				if (registry.byId('getChecked')) {
					registry.byId('getChecked').on('click', function () {
						console.log(activityGridNoThead1.getChecked());
					});
				}
				if (dom.byId('leftNav')) {
					on(dom.byId('leftNav'), 'a:click', function (e) {
						e.preventDefault();
						var link = domAttr.get(this, 'href').split('#')[1],
						position = domGeom.position(dom.byId(link), true),
						tag = this;
						if (position.y === 75) {
							position.y = 0;
						}
						
						window.scrollTo(position.x, position.y);
						setTimeout(function () {
                            domClass.remove(query('.nav-list .active')[0], 'active');
                            domClass.add(tag.parentNode, 'active');					
						}, 100);
					});
				}
				
			//});

		});

		
})();
