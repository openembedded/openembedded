DESCRIPTION = "Epdf is the glue between EFL and libpoppler"
LICENSE = "MIT BSD"
DEPENDS = "poppler evas ecore"
PV = "0.1.0+svnr${SRCPV}"
PR = "r3"
SRCREV = "${EFL_SRCREV}"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=epdf;proto=http"
#           file://fix-plugin-path-check.patch;HACK=1;patch=1"
# FIXME This package is not really working correctly at the moment. It doesn't
# recognize epsilon and doesn't build everything. The next one actually using
# this package is welcome to fix it.


# add ewl additions
FILES_${PN}-dev += "${libdir}/ewl/tests/*.a ${libdir}/ewl/tests/*.la"
FILES_${PN}-dbg += "${libdir}/ewl/tests/.debug"

# add epsilon additions
FILES_${PN}-dev += "${libdir}/epsilon/plugins/epdf_thumbnailer.a ${libdir}/epsilon/plugins/epdf_thumbnailer.la"
FILES_${PN}-dbg += "${libdir}/epsilon/plugins/.debug"

PACKAGES += "${PN}-ewl-widget epsilon-plugin-${PN}"
FILES_${PN}-ewl-widget = "${libdir}/ewl/tests/libewl_pdf*.so*"
FILES_epsilon-plugin-${PN} = "${libdir}/epsilon/plugins/epdf_thumbnailer.so*"

