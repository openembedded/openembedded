
SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
PV = "0.0+gitr${SRCiPV}"
PR = "r0"
PE = "1"

DEPENDS = "libsoup-2.4"

S = "${WORKDIR}/git"

inherit autotools_stage

do_configure_prepend () {
	echo "EXTRA_DIST=" > ${S}/gtk-doc.make
}
