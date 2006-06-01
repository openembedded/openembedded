LICENSE = "GPL"
DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.72+cvs${SRCDATE}"
PR = "r1"

PARALLEL_MAKE = ""
inherit autotools gpe

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

DEPENDS = "libhandoff libsoup libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

