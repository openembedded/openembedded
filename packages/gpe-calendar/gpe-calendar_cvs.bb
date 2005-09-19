LICENSE = "GPL"
DEFAULT_PREFERENCE = "-1"

S =     "${WORKDIR}/${PN}"
PV =        "0.65+cvs-${CVSDATE}"
PR = "r0"

inherit autotools gpe

SRC_URI =   "cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=gpe/base/${PN}"


DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

