require u-boot.inc
PR="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
