DEPENDS = "libgpewidget libgpelaunch gtk+"
SECTION = "gpe"
DESCRIPTION = "GPE calendar"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"

PV = "0.1+cvs${SRCDATE}"
PR = "r1"

inherit autotools gpe

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"
S = "${WORKDIR}/${PN}"



