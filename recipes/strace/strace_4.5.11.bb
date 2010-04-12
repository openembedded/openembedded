LICENSE = "GPL"
SECTION = "console/utils"
PR = "r2"

DESCRIPTION = "strace is a system call tracing tool."

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
	   file://arm-syscallent.patch;patch=1 \
	   file://quota.patch;patch=1"

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "28335e15c83456a3db055a0a0efcb4fe"
SRC_URI[sha256sum] = "9de428477d4d3f383d58c2f16b2544da2a5ec0acc50ee90ecb81dfe38f56edb8"
