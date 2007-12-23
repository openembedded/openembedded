DESCRIPTION = "Epdf is the glue between EFL and libpoppler"
LICENSE = "BSD"
DEPENDS = "poppler evas ecore etk ewl"
PV = "0.1.0+cvs${SRCDATE}"
PR = "r1"

inherit efl_library

SRC_URI = "${E_CVS};module=e17/proto/${SRCNAME} \
           file://fix-plugin-path-check.patch;HACK=1;patch=1"

# add ewl additions
FILES_${PN}-dev += "${libdir}/ewl/tests/*.a ${libdir}/ewl/tests/*.la"
FILES_${PN}-dbg += "${libdir}/ewl/tests/.debug"

# add epsilon additions
FILES_${PN}-dev += "${libdir}/epsilon/plugins/epdf_thumbnailer.a ${libdir}/epsilon/plugins/epdf_thumbnailer.la"
FILES_${PN}-dbg += "${libdir}/epsilon/plugins/.debug"

PACKAGES += "${PN}-ewl-widget epsilon-plugin-${PN}"
FILES_${PN}-ewl-widget = "${libdir}/ewl/tests/libewl_pdf*.so*"
FILES_epsilon-plugin-${PN} = "${libdir}/epsilon/plugins/epdf_thumbnailer.so*"

