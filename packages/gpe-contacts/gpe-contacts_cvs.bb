LICENSE = "GPL"
DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.43+cvs${SRCDATE}"
PR = "r0"

inherit autotools gpe

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"


DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"
