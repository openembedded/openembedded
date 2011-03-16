DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://www.valgrind.org/"
SECTION = "devel"
LICENSE = "GPLv2"
DEPENDS = "virtual/libx11"
PR = "r0"

SRC_URI = "http://www.valgrind.org/downloads/valgrind-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--enable-tls"

PARALLEL_MAKE=""
COMPATIBLE_HOST = "^(i.86|x86_64).*-linux"

FILES_${PN}-dbg += "/usr/lib/valgrind/x86-linux/.debug"
FILES_${PN}-dbg += "/usr/lib/valgrind/amd64-linux/.debug"
