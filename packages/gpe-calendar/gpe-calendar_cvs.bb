LICENSE = "GPL"
DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.67+cvs${SRCDATE}"
PR = "r0"

inherit autotools gpe

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

