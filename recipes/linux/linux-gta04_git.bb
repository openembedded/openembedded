SRCREV="${AUTOREV}" 
PV = "2.6.37+${PR}+gitr${SRCREV}"
PR = "r1"

inherit kernel

COMPATIBLE_MACHINE = "beaglehyb"

SRC_URI = "git://projects.goldelico.com/gta04-kernel.git;protocol=git "
SRC_URI_append_beaglehyb = "file://omap3_beaglehyb_defconfig"

S = "${WORKDIR}/git"

do_configure_prepend_beaglehyb() {
	install -m 0644 ${WORKDIR}/omap3_beaglehyb_defconfig ${S}/.config
}
