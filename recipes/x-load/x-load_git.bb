require x-load.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-git/${MACHINE}"

SRCREV = "319b26586fafb86f919f514bcd175838aaab96b3"

PV = "1.42+${PR}+gitr${SRCREV}"
PR ="r8"
PE = "1"

SRC_URI = "git://gitorious.org/x-load-omap3/mainline.git;branch=master;protocol=git"

SRC_URI_append_beagleboard = " \
                              file://name.patch;patch=1 \
                             "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
