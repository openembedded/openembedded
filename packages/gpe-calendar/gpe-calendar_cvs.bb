DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "GPE calendar"
SECTION = "gpe"
LICENSE = "GPL"

DEPENDS = "libhandoff libsoup libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
RDEPENDS = "gpe-icons"

PV = "0.73+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"
S = "${WORKDIR}/${PN}"

inherit autotools gpe

PARALLEL_MAKE = ""


