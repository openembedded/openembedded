DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://www.valgrind.org/"
SECTION = "devel"
LICENSE = "GPL"
DEPENDS = "virtual/libx11"
PR = "r0"

SRC_URI = "http://www.valgrind.org/downloads/valgrind-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--enable-tls"

COMPATIBLE_HOST = "^i.86.*-linux"

FILES_${PN}-dbg += "/usr/lib/valgrind/x86-linux/.debug"
