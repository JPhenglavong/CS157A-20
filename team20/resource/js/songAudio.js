var currentPlaylist = [];
var audioElement;

function formatTime(seconds) {
	var time = Math.round(seconds);
	var minutes = Math.floor(time / 60);
	var seconds = time - minutes * 60;

	var extraZero;
	if (seconds < 10) {
		extraZero = "0";
	} else {
		extraZero = "";
	}
	return minutes + ":" + extraZero + seconds;
}

function updateTimeProgressBar(audio) {
	$(".progressTime.current").text(formatTime(audio.currentTime));
	$(".progressTime.remaining").text(formatTime(audio.duration - audio.currentTime));

	var progress = audio.currentTime / audio.duration * 100;
	// $(".playbackBar .progress").css("width", progress + "%");
	document.getElementById("progressID").style.width = progress + "%";
}


function songAudio() {
	this.currentPlaylist;
	this.audio = document.createElement('audio');
	this.audio.addEventListener("canplay", function () {
		//`this` refers to the object that the event was called on
		var formattedDuration = formatTime(this.duration);
		$(".progressTime.remaining").text(formattedDuration);
	});

	this.audio.addEventListener("timeupdate", function () {
		if (this.duration) {
			updateTimeProgressBar(this);
		}
	});

	this.setTrack = function (track) {
		this.currentlyPlaying = track;
		this.audio.src = track.path;
	}

	this.play = function () {
		this.audio.play();
	}

	this.pause = function () {
		this.audio.pause();
	}

	this.playOneSong = function (updatePlayCounts, playBtn, pauseBtn) {
		if (this.audio.currentTime == 0) {
			$.post(updatePlayCounts, { songId: this.currentlyPlaying.id });
		}

		$(playBtn).hide();
		$(pauseBtn).show();
		this.audio.play();
	}

	this.pauseOneSong = function (playBtn, pauseBtn) {
		$(playBtn).show();
		$(pauseBtn).hide();
		this.audio.pause();
	}
}





/**
 * jQuery show and hide Source Codes
 */
// jQueryShowHide() {
// 	function showHide(elements, show) {
// 		var display, elem, hidden,
// 			values = [],
// 			index = 0,
// 			length = elements.length;

// 		for (; index < length; index++) {
// 			elem = elements[index];
// 			if (!elem.style) {
// 				continue;
// 			}

// 			values[index] = jQuery._data(elem, "olddisplay");
// 			display = elem.style.display;
// 			if (show) {
// 				// Reset the inline display of this element to learn if it is
// 				// being hidden by cascaded rules or not
// 				if (!values[index] && display === "none") {
// 					elem.style.display = "";
// 				}

// 				// Set elements which have been overridden with display: none
// 				// in a stylesheet to whatever the default browser style is
// 				// for such an element
// 				if (elem.style.display === "" && isHidden(elem)) {
// 					values[index] = jQuery._data(elem, "olddisplay", defaultDisplay(elem.nodeName));
// 				}
// 			} else {
// 				hidden = isHidden(elem);

// 				if (display && display !== "none" || !hidden) {
// 					jQuery._data(elem, "olddisplay", hidden ? display : jQuery.css(elem, "display"));
// 				}
// 			}
// 		}

// 		// Set the display of most of the elements in a second loop
// 		// to avoid the constant reflow
// 		for (index = 0; index < length; index++) {
// 			elem = elements[index];
// 			if (!elem.style) {
// 				continue;
// 			}
// 			if (!show || elem.style.display === "none" || elem.style.display === "") {
// 				elem.style.display = show ? values[index] || "" : "none";
// 			}
// 		}

// 		return elements;
// 	}


// 	jQuery.fn.extend({

// 		show: function () {
// 			return showHide(this, true);
// 		}
// 	});



// 	/**
//   * Determines whether an object can have data
//   */
// 	jQuery.acceptData = function (elem) {
// 		var noData = jQuery.noData[(elem.nodeName + " ").toLowerCase()],
// 			nodeType = +elem.nodeType || 1;

// 		// Do not set data on non-element DOM nodes because it will not be cleared (#8335).
// 		return nodeType !== 1 && nodeType !== 9 ?
// 			false :

// 			// Nodes accept data unless otherwise specified; rejection can be conditional
// 			!noData || noData !== true && elem.getAttribute("classid") === noData;
// 	};

// 	function internalRemoveData(elem, name, pvt) {
// 		if (!jQuery.acceptData(elem)) {
// 			return;
// 		}

// 		var thisCache, i,
// 			isNode = elem.nodeType,

// 			// See jQuery.data for more information
// 			cache = isNode ? jQuery.cache : elem,
// 			id = isNode ? elem[jQuery.expando] : jQuery.expando;

// 		// If there is already no cache entry for this object, there is no
// 		// purpose in continuing
// 		if (!cache[id]) {
// 			return;
// 		}

// 		if (name) {

// 			thisCache = pvt ? cache[id] : cache[id].data;

// 			if (thisCache) {

// 				// Support array or space separated string names for data keys
// 				if (!jQuery.isArray(name)) {

// 					// try the string as a key before any manipulation
// 					if (name in thisCache) {
// 						name = [name];
// 					} else {

// 						// split the camel cased version by spaces unless a key with the spaces exists
// 						name = jQuery.camelCase(name);
// 						if (name in thisCache) {
// 							name = [name];
// 						} else {
// 							name = name.split(" ");
// 						}
// 					}
// 				} else {
// 					// If "name" is an array of keys...
// 					// When data is initially created, via ("key", "val") signature,
// 					// keys will be converted to camelCase.
// 					// Since there is no way to tell _how_ a key was added, remove
// 					// both plain key and camelCase key. #12786
// 					// This will only penalize the array argument path.
// 					name = name.concat(jQuery.map(name, jQuery.camelCase));
// 				}

// 				i = name.length;
// 				while (i--) {
// 					delete thisCache[name[i]];
// 				}

// 				// If there is no data left in the cache, we want to continue
// 				// and let the cache object itself get destroyed
// 				if (pvt ? !isEmptyDataObject(thisCache) : !jQuery.isEmptyObject(thisCache)) {
// 					return;
// 				}
// 			}
// 		}

// 		// See jQuery.data for more information
// 		if (!pvt) {
// 			delete cache[id].data;

// 			// Don't destroy the parent cache unless the internal data object
// 			// had been the only thing left in it
// 			if (!isEmptyDataObject(cache[id])) {
// 				return;
// 			}
// 		}

// 		// Destroy the cache
// 		if (isNode) {
// 			jQuery.cleanData([elem], true);

// 			// Use delete when supported for expandos or `cache` is not a window per isWindow (#10080)
// 			/* jshint eqeqeq: false */
// 		} else if (support.deleteExpando || cache != cache.window) {
// 			/* jshint eqeqeq: true */
// 			delete cache[id];

// 			// When all else fails, null
// 		} else {
// 			cache[id] = null;
// 		}
// 	}

// 	jQuery.extend({
// 		cache: {},

// 		// The following elements (space-suffixed to avoid Object.prototype collisions)
// 		// throw uncatchable exceptions if you attempt to set expando properties
// 		noData: {
// 			"applet ": true,
// 			"embed ": true,
// 			// ...but Flash objects (which have this classid) *can* handle expandos
// 			"object ": "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
// 		},

// 		hasData: function (elem) {
// 			elem = elem.nodeType ? jQuery.cache[elem[jQuery.expando]] : elem[jQuery.expando];
// 			return !!elem && !isEmptyDataObject(elem);
// 		},

// 		data: function (elem, name, data) {
// 			return internalData(elem, name, data);
// 		},

// 		removeData: function (elem, name) {
// 			return internalRemoveData(elem, name);
// 		},

// 		// For internal use only.
// 		_data: function (elem, name, data) {
// 			return internalData(elem, name, data, true);
// 		},

// 		_removeData: function (elem, name) {
// 			return internalRemoveData(elem, name, true);
// 		}
// 	});
// }



















