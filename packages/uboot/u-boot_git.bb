require u-boot.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit base
