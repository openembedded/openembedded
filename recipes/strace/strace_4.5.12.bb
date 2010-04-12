LICENSE = "GPL"
SECTION = "console/utils"
PR = "r1"

DESCRIPTION = "strace is a system call tracing tool."

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
	   file://arm-syscallent.patch;patch=1 \
	   file://quota.patch;patch=1 \
	   file://strace-fix-arm-bad-syscall.patch;patch=1"

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "c9dc77b9bd7f144f317e8289e0f6d40b"
SRC_URI[sha256sum] = "d8d9d62f0ebab71fab62b5ba7eaddd8bb8df9b7f4988b4a8e0d0724662702acf"
