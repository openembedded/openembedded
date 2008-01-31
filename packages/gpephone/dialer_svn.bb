DESCRIPTION = "GPE Phone Edition phone dialer"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ libgpephone libgemwidget"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"

inherit gpephone autotools

SRC_URI = ${GPEPHONE_SVN}

EXTRA_OECONF = "--disable-hiker"

S = "${WORKDIR}/${PN}"


FILES_${PN} += "${datadir}"

DEFAULT_PREFERENCE = "-1"
