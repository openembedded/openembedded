require x-load.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-git/${MACHINE}"

SRCREV = "04ad40d5c8bca196aa4a5dfe945a007e21f1b149"

PV = "1.41+${PR}+git${SRCREV}"
PR="r6"

SRC_URI = "git://www.sakoman.net/git/x-load-omap3.git;branch=master;protocol=git"

SRC_URI_append_beagleboard = " \
                              file://name.patch;patch=1 \
                              file://armv7-a.patch;patch=1 \
                             "

SRC_URI_append_omap3evm = " \
                              file://armv7-a.patch;patch=1 \
                             "

SRC_URI_append_overo = " \
                              file://armv7-a.patch;patch=1 \
                             "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
