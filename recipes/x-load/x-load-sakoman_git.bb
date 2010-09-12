require x-load.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-sakoman-git/${MACHINE}"

PV = "1.44ss+${PR}+gitr${SRCREV}"

SRCREV = ${AUTOREV}
SRC_URI = "git://www.sakoman.com/git/x-loader.git;branch=master;protocol=git"

SRCREV_omap4430-sdp = ${AUTOREV}
SRC_URI_omap4430-sdp = "git://dev.omapzoom.org/pub/scm/bootloader/x-loader.git;branch=omap4_dev;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
