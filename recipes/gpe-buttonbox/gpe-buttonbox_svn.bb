DESCRIPTION = "Buttonbox for gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget libgpelaunch"
PV = "0.5+svn-${SRCDATE}"
PR = "r0"

inherit autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

FILES_${PN} += "${datadir}/gpe"

DEFAULT_PREFERENCE = "-1"
