require u-boot.inc
PR="r1"
DEFAULT_PREFERENCE = "-1"

SRCREV_davinci-sffsdr = "4ce1e23b5e12283579828b3d23e8fd6e1328a7aa"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

SRC_URI_append_davinci-sffsdr = " file://sffsdr-u-boot.patch;patch=1 "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
