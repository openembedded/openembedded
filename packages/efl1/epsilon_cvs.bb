DESCRIPTION = "Epsilon is a flexible and powerful image thumbnailing library \
that is compliant with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "BSD"
# can also depend on xine for movie thumbnails
DEPENDS = "imlib2 epeg libpng evas ecore edje perl-native"
PV = "0.3.0+cvs${SRCDATE}"

inherit efl_library

# a gstreamer thumbnailer would be nice now that we have emotion using gstreamer as well
EXTRA_OECONF = "--disable-xine"

FILES_${PN}-dev += "${libdir}/${PN}/*/*.a ${libdir}/${PN}/*/*.la"
FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug/*.so"
