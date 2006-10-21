DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "GPE calendar"
SECTION = "gpe"
LICENSE = "GPL"

DEPENDS = "libhandoff libsoup libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
RDEPENDS = "gpe-icons"

inherit autotools gpe


PV = "0.72+svn${SRCDATE}"
PR = "r0"

SRC_URI = "${GPE_SVN}"
S = "${WORKDIR}/${PN}"


PARALLEL_MAKE = ""


