DESCRIPTION = "Simple ffmpeg-based player that uses the omapfb overlays"
DEPENDS = "bzip2 lame ffmpeg virtual/kernel"
LICENSE = "MIT"

PR = "r13"

inherit module-base

PV = "0.0+${PR}+gitr${SRCREV}"

SRCREV = "0e4b69dbdc807da9b51e97fcffd8e26427b57162"
SRC_URI = "git://git.mansr.com/${PN};protocol=git \
           file://fbplay-static.diff;patch=1 "

S = "${WORKDIR}/git"


CFLAGS += " -I${STAGING_KERNEL_DIR}/include "

do_compile() {
	oe_runmake -e
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/omapfbplay ${D}/${bindir}/
}
