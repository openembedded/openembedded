DESCRIPTION = "Performance tracing library for gstreamer."
LICENSE = "LGPLv2"

DEPENDS = "gstreamer glib-2.0 gtk+"

inherit autotools gettext lib_package

PV = "0.2"

PR_append = "+gitr${SRCPV}"
SRCREV = "499e6b2be97d0c65c76e47cbcc1f165f23645141"
SRC_URI = "git://anongit.freedesktop.org/~ensonic/gst-tracelib;protocol=git"

S = "${WORKDIR}/git"

RRECOMMENDS_${PN}-bin += "gnuplot"

