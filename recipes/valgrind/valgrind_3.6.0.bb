DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://www.valgrind.org/"
SECTION = "devel"
LICENSE = "GPLv2"
DEPENDS = "virtual/libx11"
PR = "r0"

SRC_URI = "http://www.valgrind.org/downloads/valgrind-${PV}.tar.bz2 \
	file://fix-link-tool.patch"

inherit autotools

EXTRA_OECONF = "--enable-tls"

PARALLEL_MAKE=""
COMPATIBLE_HOST = "^(i.86|x86_64).*-linux"

FILES_${PN}-dbg += "/usr/lib/valgrind/x86-linux/.debug"
FILES_${PN}-dbg += "/usr/lib/valgrind/amd64-linux/.debug"

SRC_URI[md5sum] = "b289c5f4ab8e39741602445f1dd09b34"
SRC_URI[sha256sum] = "bc0f0153b5a47b986f1d8efa2c488e0aea85a1cf2c4b11c52be127903080285f"
