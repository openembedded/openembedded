DESCRIPTION = "Epsilon is a flexible and powerful image thumbnailing library \
that is compliant with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "BSD"
# can also depend on xine for movie thumbnails
DEPENDS = "imlib2 epeg libpng evas ecore edje perl-native"
PR = "r1"

inherit efl1

PACKAGES =+ "epsilon-tests"
FILES_epsilon-tests = "${bindir}/${PN} ${bindir}/*_* ${datadir}"
FILES_${PN} = "${libdir}/lib*.so*"
