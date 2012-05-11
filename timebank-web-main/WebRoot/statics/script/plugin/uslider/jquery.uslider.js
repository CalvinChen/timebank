(function(b) {
	var d = function(a, b) {
		return d.fn.create(a, b)
	};
	d.fn = d.prototype = {
		version : "1.0.0",
		create : function(a, c) {
			this.options = b.extend(!0, b.fn.uSlider.defaults, c);
			this.vars = {
				sC : 0,
				lS : 0,
				cS : 0,
				r : 0,
				fxs : [],
				t : !1
			};
			this.panel = {
				timer : null
			};
			this.panel.showScreen = b(a);
			b(a).addClass("uslider-vertical-slider");
			b(a).wrap("<div class='slide-wrapper'/>");
			this.slider = b(a).parent();
			this.items = b(a).children();
			this.slideSize();
			this.options.pause && this.setPauseOnHover();
			this.panel.timer = new uST(a, {
				duration : this.options.duration,
				oncomplete : b.proxy(function() {
					try {
						this.vars.r = 0, this.vars.lS = this.vars.cS, this.vars.cS++, this
								.transit()
					} catch (a) {
					}
					this.panel.timer.start()
				}, this)
			});
			this.setHoverNavigation();
			this.options.autoplay && this.items.length > 1
					&& this.panel.timer.start()
		},
		slideSize : function() {
			this.items.each(b.proxy(function(a, d) {
						this.vars.sC++;
						b(d).css({
									zIndex : a + 5,
									left : a * this.options.distance + "px"
								});
						b(d).attr("rel", a)
					}, this));
			if (this.vars.sC != 0) {
				this.vars.cS >= 0
						&& this.vars.cS < this.items.length
						&& (this.items.eq(parseInt(this.vars.cS))
								.children("img")[0].complete ? this
								.afterLoadImage() : this.items
								.eq(parseInt(this.vars.cS)).children("img")
								.load(b.proxy(this.afterLoadImage, this)));
				for (var a = 0; a < this.items.length; a++)
					a != this.vars.cS
							&& (this.items.eq(a).children("img")[0].complete
									? this.items.eq(a).children("img")
											.siblings().width(this.items.eq(a)
													.children("img").width()
													+ "px")
									: this.items.eq(parseInt(a))
											.children("img").load(function() {
												b(this).siblings()
														.width(b(this).width()
																+ "px")
											}))
			}
		},
		afterLoadImage : function() {
			miw = b("img", this.items.eq(this.vars.cS)).width();
			mih = b("img", this.items.eq(this.vars.cS)).height();
			this.slider.width(parseInt(miw + this.options.distance
					* (this.items.length - 1))
					+ "px");
			this.slider.height(mih + "px");
			this.items.eq(this.vars.cS).children("img").siblings().width(miw
					+ "px");
			for (var a = this.vars.cS + 1; a < this.items.length; a++)
				this.items.eq(a).css({
					left : parseInt((a - 1) * this.options.distance + miw)
							+ "px"
				})
		},
		setClickSelector : function() {
			var a = this;
			this.items.click(function() {
				if (!a.vars.t) {
					a.stopProgress(), a.vars.lS = a.vars.cS, a.vars.cS = b(this)
							.attr("rel"), a.transit()
				}
			})
		},
		setHoverNavigation : function() {
			var a = this;
			this.items.bind("mouseenter", function() {
						a.stopProgress();
						a.vars.lS = a.vars.cS;
						a.vars.cS = b(this).attr("rel");
						a.transit()
					})
		},
		setPauseOnHover : function() {
			this.slider.hover(b.proxy(function() {
								this.vars.paused = !0;
								this.pauseProgress()
							}, this), b.proxy(function() {
								this.vars.paused = !1;
								this.vars.running = !1;
								this.options.pause && this.startProgress()
							}, this));
		},
		stopProgress : function() {
			this.panel.timer.stop();
		},
		pauseProgress : function() {
			this.panel.timer.pause();
		},
		startProgress : function() {
			this.panel.timer.start();
		},
		transit : function() {
			if (this.vars.cS == this.vars.sC) {
				this.vars.cS = 0, this.options.slideshowEnd
						&& this.options.slideshowEnd.call(this);
			} else if (this.vars.cS < 0) {
				this.vars.cS = this.vars.sC - 1;
			}
			this.items.removeClass("current-slide");
			this.items.stop();
			this.vars.t = !0;
			this.items.eq(this.vars.cS).animate({
						left : this.vars.cS * this.options.distance + "px"
					}, b.proxy(function() {
								this.vars.t = !1
							}, this));
			for (var a = this.items.eq(this.vars.cS).children("img").width(), c = 0; c < this.vars.cS; c++)
				this.items.eq(c).animate({
							left : c * this.options.distance + "px"
						});
			for (c = parseInt(this.vars.cS) + 1; c < this.items.length; c++)
				this.items.eq(c).animate({
							left : (c - 1) * this.options.distance + a + "px"
						})
		}
	};
	b.fn.uSlider = function(a) {
		return this.each(function() {
					var c = b(this);
					if (c.data("uslider")) {
						return c.data("uslider");
					}
					var e = new d(this, a);
					c.data("uslider", e)
				})
	};
	b.fn.uSlider.defaults = {
		autoplay : !0,
		pause : !0,
		duration : 3E3,
		distance : 40
	}
})(jQuery);
(function(b) {
	function d() {
		return (new Date).getTime()
	}
	uST = function(a, b) {
		return uST.fn.create(a, b);
	};
	var a = d();
	uST.fn = uST.prototype = {
		version : "1.0.0.0",
		create : function(c, e) {
			this.options = b.extend(!0, {
						width : 32,
						height : 32,
						radius : 12,
						duration : 3E3,
						oncomplete : null
					}, e);
			this.vars = {
				supportCanvas : !0,
				startTime : 0,
				lastPauseResidue : 0,
				pause : !0
			};
			this.timer = null;
			a = this.vars.startTime = d();
			setInterval(b.proxy(this.reset, this), 16);
			setInterval(b.proxy(this.reset, this), 30)
		},
		stop : function() {
			this.vars.lastPauseResidue = 0;
			this.vars.pause = !0;
		},
		pause : function() {
			this.vars.lastPauseResidue = d() - this.vars.startTime
					+ this.vars.lastPauseResidue;
			this.vars.pause = !0;
		},
		start : function() {
			this.vars.startTime = d();
			this.vars.pause = !1;
		},
		reset : function() {
			var b = d();
			if (b - a >= 30) {
				if (this.vars.pause == !1
						&& b - this.vars.startTime + this.vars.lastPauseResidue >= this.options.duration
						&& (this.vars.lastPauseResidue = 0, this.vars.pause = !0, this.options.oncomplete)) {
					this.options.oncomplete();
				}
				a = b;
			}
		}
	}
})(jQuery);