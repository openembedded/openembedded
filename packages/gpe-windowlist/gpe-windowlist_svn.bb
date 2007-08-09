DESCRIPTION = "GPE windowlist applet"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget libgpelaunch gtk+"
PV = "0.1+svn${SRCDATE}"
PR = "r1"

inherit autotools 

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
