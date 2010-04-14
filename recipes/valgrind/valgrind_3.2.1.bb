DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://www.valgrind.org/"
SECTION = "devel"
LICENSE = "GPL"
DEPENDS = "virtual/libx11"
PR = "r0"

SRC_URI = "http://www.valgrind.org/downloads/archive/valgrind-${PV}.tar.bz2"

SRC_URI[md5sum] = "9407d33961186814cef0e6ecedfd6318"
SRC_URI[sha256sum] = "7f9a15d7be16ca03a0912191e8d55a486bf69690e11bb76ccece3eaff3730a33"

inherit autotools

EXTRA_OECONF = "--enable-tls"

COMPATIBLE_HOST = "^i.86.*-linux"
