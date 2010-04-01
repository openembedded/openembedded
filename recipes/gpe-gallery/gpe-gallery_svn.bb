DESCRIPTION = "GPE image viewer application"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget"
SRCREV = "9376"
PV = "0.97+svnr${SRCPV}"

inherit autotools 
export CVSBUILD = "no"

SRC_URI = "${GPE_EXTRA_SVN}"
S = "${WORKDIR}/${PN}"

FILES_${PN} += "${datadir}/gpe/pixmaps"
FILES_${PN} += "${datadir}/application-registry"
