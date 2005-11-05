DESCRIPTION = "ltrace is a library call tracing tool."
PR = "1"

SRC_URI = "${DEBIAN_MIRROR}/main/l/ltrace/ltrace_0.3.35.tar.gz \
	  file://no_global_includes.patch;patch=1 "

inherit autotools

EXTRA_OEMAKE = "ARCH=${HOST_ARCH}"

S = "${WORKDIR}/ltrace-${PV}"
