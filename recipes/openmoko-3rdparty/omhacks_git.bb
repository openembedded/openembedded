DESCRIPTION = "C library of useful functions to control OpenMoko hardware."
AUTHOR = "Enrico Zini <enrico@enricozini.org>"
HOMEPAGE = "http://git.debian.org/?p=pkg-fso/omhacks.git;a=blob;f=README"
SECTION = "openmoko/tools"
PRIORITY = "optional"
LICENSE = "GPLv2"
PV = "0.11+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.debian.org/pkg-fso/omhacks.git;protocol=git;branch=master"

SRCREV = "a278146b56b51a8590650702fc08c25aa54a3d32"
S = "${WORKDIR}/git"

inherit cmake

FILES_${PN} += "${prefix}/lib/pm-utils"
FILES_${PN}-dbg += "${prefix}/lib/pm-utils/sleep.d/.debug"
