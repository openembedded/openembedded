inherit gpe autotools

DESCRIPTION = "GPE wireless LAN communication applet"
DEPENDS  = "gtk+ libgpewidget prismstumbler"
RDEPENDS_${PN} = "prismstumbler"
SECTION  = "gpe"
PRIORITY = "optional"
LICENSE  = "GPL"
PR = "r1"
PV = "0.3.0+svn${SRCDATE}"

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/gpe-aerial"

DEFAULT_PREFERENCE = "-1"
