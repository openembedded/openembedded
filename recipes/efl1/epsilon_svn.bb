DESCRIPTION = "Epsilon is a flexible and powerful image thumbnailing library \
that is compliant with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "MIT BSD"
# can also depend on xine for movie thumbnails
DEPENDS = "libpng evas ecore edje perl-native"
PV = "0.3.0.012+svnr${SRCPV}"
PR = "r4"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${SRCNAME};proto=http"

# a gstreamer thumbnailer would be nice now that we have emotion using gstreamer as well
EXTRA_OECONF = "--disable-xine"

# package the thumb daemon seperately
PACKAGES =+ "${PN}-thumbd"
FILES_${PN}-thumbd = "${bindir}/epsilon ${bindir}/epsilon_thumbd"
RRECOMMENDS_${PN} = "${PN}-thumbd"

FILES_${PN}-dev += "${libdir}/${PN}/*/*.a ${libdir}/${PN}/*/*.la"
FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug/*.so"

