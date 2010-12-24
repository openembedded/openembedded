require linux.inc

FILESPATHPKG =. "linux-efikamx-git/${MACHINE}:"

SRCREV = "efikasb-10.08.00-20101205"
PV = "2.6.31.14"

PR = "r0"

#SRC_URI = "git://git.linaro.org/people/amitk/linux-2.6.git;branch=wip-efikamx-cleanup3;protocol=git \
SRC_URI = "git://gitorious.org/efikamx/linux-kernel.git;branch=efikasb-10.08.00;protocol=git \
	   file://defconfig"

COMPATIBLE_MACHINE = "(efikamx)"

S = "${WORKDIR}/git"
