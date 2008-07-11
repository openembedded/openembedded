require u-boot.inc
PR="r9"

SRCREV_davinci-sffsdr = "a524e112b424c6843800ea2f19d3a8cf01d0aa94"
SRCREV_beagleboard = "9b55a2536919f4de1bb1044e6eb8262c2f53bc96"
SRCREV_neuros-osd2 = "482dfe48845192c7f810bccfc93db93d0f1654f7"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "
SRC_URI_neuros-osd2 = "git://git.neurostechnology.com/git/u-boot;protocol=git;branch=neuros"
SRC_URI_append_davinci-sffsdr = " file://sffsdr-u-boot.patch;patch=1 "

SRC_URI_append_beagleboard = "file://base.patch;patch=1 \
                              file://name.patch;patch=1 \
                              file://armv7-a.patch;patch=1 \
                             "

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch;patch=1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
