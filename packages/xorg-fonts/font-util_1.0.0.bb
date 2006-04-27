include font-common.inc

DEPENDS = "bdftopcf"

FILES_${PN} = "${bindir}/* ${libdir}/X11/fonts/util/*"
