DESCRIPTION = "GPE image viewer application"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget"
PV = "0.97+svn-${SRCDATE}"

inherit autotools 
export CVSBUILD = "no"

SRC_URI += "${GPE_EXTRA_SVN} \
	    file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

FILES_${PN} += "${datadir}/gpe/pixmaps"
FILES_${PN} += "${datadir}/application-registry"


DEFAULT_PREFERENCE = "-1"
