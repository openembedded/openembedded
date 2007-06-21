DESCRIPTION = "Epsilon is a flexible and powerful image thumbnailing library \
that is compliant with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "LGPL"
DEPENDS = "imlib2 epeg libpng evas ecore edje perl-native"

inherit efl1

PR = "r0"

PACKAGES =+ "epsilon-tests"
FILES_epsilon-tests = "${bindir}/*_* ${datadir}"
FILES_${PN} = "${libdir}/lib*.so*"
