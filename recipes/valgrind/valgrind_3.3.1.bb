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

SRC_URI[md5sum] = "0539e2fa4aadb2cd4ca4bba65b1fe8b5"
SRC_URI[sha256sum] = "95b7b4d815bd479332637c93e69ec24167cd28d4f9d9f9b718e1b091bb88aafa"
