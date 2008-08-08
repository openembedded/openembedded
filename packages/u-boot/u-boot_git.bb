require u-boot.inc
PR="r15"

SRCREV_davinci-sffsdr = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_davinci-dvevm = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_beagleboard = "9c1c36409b2cb4e81aab0bd9d0a69c68f4475aae"
SRCREV_neuros-osd2 = "528a4ab736758ff0c889456d46673041eb52f756"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "
SRC_URI_neuros-osd2 = "git://git.neurostechnology.com/git/u-boot;protocol=git;branch=neuros"
SRC_URI_beagleboard = "git://www.sakoman.net/git/u-boot-omap3.git;branch=test;protocol=git \
                       file://name.patch;patch=1 \
                       file://armv7-a.patch;patch=1 \
                      "

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch;patch=1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
