DESCRIPTION = "GPE network connection checker"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget gpe-icons gpe-conf"
RRECOMMENDS = "gpe-conf"
PR = "r0"
PV = "0.7+svn-${SRCDATE}"

inherit autotools pkgconfig

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/${PN}"

FILES_${PN} = " ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

DEFAULT_PREFERENCE = "-1"
