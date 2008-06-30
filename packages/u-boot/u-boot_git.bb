require u-boot.inc
PR="r4"

SRCREV_davinci-sffsdr = "4ce1e23b5e12283579828b3d23e8fd6e1328a7aa"
SRCREV_beagleboard = "a94f22f08f280905926219e568568964cb9eeb9d"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

SRC_URI_append_davinci-sffsdr = " file://sffsdr-u-boot.patch;patch=1 "

SRC_URI_append_beagleboard = "file://base.patch;patch=1 \
                              file://name.patch;patch=1 \
                              file://armv7-a.patch;patch=1 \
                             "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
