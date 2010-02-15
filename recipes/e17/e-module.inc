DESCRIPTION = "E17 ${PN} module"
SECTION = "x11/multimedia"
DEPENDS = "e-wm"

SRCREV = "${EFL_SRCREV}"

SRCNAME = "E-MODULES-EXTRA/${PN}"

inherit e

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} += "${libdir}/enlightenment/modules/${PN}"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/${PN}/*/.debug"

