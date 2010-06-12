DESCRIPTION = "GPE contacts manager"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus"
RDEPENDS_${PN} = "gpe-icons"
SRCREV = "9312"
PV = "0.47+svnr${SRCPV}"
PR = "r3"

inherit autotools gpe

SRC_URI = "${GPE_SVN}"
SRC_URI += "file://handle-import-categories.patch"

S = "${WORKDIR}/${PN}"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

DEFAULT_PREFERENCE = "-1"

