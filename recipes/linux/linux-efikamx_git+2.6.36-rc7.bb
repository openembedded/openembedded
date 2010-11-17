require linux.inc

DEFAULT_PREFERENCE = "-1"
FILESPATHPKG =. "linux-efikamx-git/${MACHINE}:"

SRCREV = "85d9835be629110084a518f3c02ce852929fbff7"
PV = "2.6.36-rc7"

PR = "r0"

SRC_URI = "git://git.linaro.org/people/amitk/linux-2.6.git;branch=wip-efikamx-cleanup3;protocol=git \
	   file://defconfig"

COMPATIBLE_MACHINE = "(efikamx)"

S = "${WORKDIR}/git"
