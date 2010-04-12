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

SRC_URI[md5sum] = "978847992b136c8d8cb5c6559a91df1c"
SRC_URI[sha256sum] = "1bca920527f43fd0c68e8f8eb16a7996b34f415e73af54de0f2cd43a8247c441"
