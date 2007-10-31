require u-boot.inc
PR="r1"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_mpc8323e-rdb = "1"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "
SRC_URI_mpc8313e-rdb = "git://www.denx.de/git/u-boot.git;protocol=git;tag=c5441f61a3d8b7034f19fc1361183e936198e6dbb "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit base
