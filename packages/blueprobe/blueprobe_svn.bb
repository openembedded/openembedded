PV = "0.18+svn${SRCDATE}"
PR = "r0"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_SVN} \
           file://blueprobe-svn-Makefile.patch;patch=1"

S = "${WORKDIR}/${PN}"

require blueprobe.inc

DEFAULT_PREFERENCE = "-1"
