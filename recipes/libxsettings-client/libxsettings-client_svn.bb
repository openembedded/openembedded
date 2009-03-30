require libxsettings-client.inc

DEPENDS += "gtk-doc"
PV = "0.17+svn${SRCDATE}"
PR = "r1"

SRC_URI = "${GPE_SVN}"
S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
