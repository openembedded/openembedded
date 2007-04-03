DESCRIPTION = "GPE contacts manager"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus"
RDEPENDS = "gpe-icons"
PV = "0.43+svn${SRCDATE}"
PR = "r0"

inherit autotools gpe

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

DEFAULT_PREFERENCE = "-1"

