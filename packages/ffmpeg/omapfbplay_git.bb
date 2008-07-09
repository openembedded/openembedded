DESCRIPTION = "Simple ffmpeg-based player that uses the omapfb overlays"
DEPENDS = "ffmpeg virtual/kernel"
LICENSE = "MIT"

inherit module-base

PV = "0.0+${PR}+gitr${SRCREV}"

SRCREV = "980e6e293f380ec038643c2110aec34f0b96697d"
SRC_URI = "git://git.mansr.com/${PN};protocol=git"

S = "${WORKDIR}/git"


CFLAGS += "-I${STAGING_KERNEL_DIR}/include "

do_compile() {
	oe_runmake -e
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/omapfbplay ${D}/${bindir}/
}
