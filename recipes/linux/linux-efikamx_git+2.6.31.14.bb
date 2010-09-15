require linux.inc

FILESPATHPKG =. "linux-efikamx-git/${MACHINE}:"

DEFAULT_PREFERENCE = "-1"

SRCREV = "21ec3b1b1ab24c1cba6cb932b3572fb19d10e701"
PV = "2.6.31.14"

PR = "r0"

SRC_URI = "git://gitorious.org/efikamx/linux-kernel.git;protocol=git \
	   file://defconfig"

COMPATIBLE_MACHINE = "(efikamx)"

S = "${WORKDIR}/git"
