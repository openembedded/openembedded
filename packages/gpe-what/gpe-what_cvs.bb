LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"
S = "${WORKDIR}/${PN}"
PV = "0.41+cvs${SRCDATE}"
PR = "r0"

inherit autotools gpe

SRC_URI =   "${HANDHELDS_CVS};module=gpe/base/${PN}"

DESCRIPTION = "GPE modal help"
DEPENDS = "x11 gtk+"
