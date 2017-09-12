(function ($) {
    $.fn.nincre = function (options) {
        var settings = $.extend({}, $.fn.nincre.defaults, options);
        return this.each(function () {
            var startFrom = settings.startFrom;
            var match = startFrom.toString().startsWith('+') || startFrom.toString().startsWith('-');
            if(match) {
                startFrom = parseInt($(this).text()) + startFrom;
            }
            startFrom = parseFloat(startFrom).toFixed(2);
            $(this).prop('Counter', startFrom).animate({
                Counter: $(this).text()
            }, {
                    duration: settings.duration,
                    easing: 'swing',
                    step: function (now) {
                        $(this).text(parseFloat(now).toFixed(2));
                    }
                });
        });
    };
    $.fn.nincre.defaults = {
        duration: 4000,
        startFrom: 0.00
    }
})(jQuery);