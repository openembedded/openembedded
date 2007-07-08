DESCRIPTION = "Epsilon is a flexible and powerful image thumbnailing library \
that is compliant with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "BSD"
# can also depend on xine for movie thumbnails
DEPENDS = "imlib2 epeg epdf libpng evas ecore edje perl-native"
PV = "0.3.0.009+cvs${SRCDATE}"

inherit efl1

SRC_URI = "${E_CVS};module=e17/libs/epsilon"
S = "${WORKDIR}/epsilon"

PACKAGES =+ "epsilon-tests"
FILES_epsilon-tests = "${bindir}/${PN} ${bindir}/*_* ${datadir}"
FILES_${PN} = "${libdir}/lib*.so* ${libdir}/${PN}/plugins/*.so"
FILES_${PN}-dev += "${libdir}/${PN}/*/*.a ${libdir}/${PN}/*/*.la"
FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug/*.so"
