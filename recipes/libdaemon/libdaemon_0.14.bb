DESCRIPTION = "libdaemon is a lightweight C library that eases the writing of UNIX daemons."
SECTION = "libs"
AUTHOR = "Lennart Poettering <lennart@poettering.net>"
HOMEPAGE = "http://0pointer.de/lennart/projects/libdaemon/"
LICENSE = "LGPL2.1+"

SRC_URI = "http://0pointer.de/lennart/projects/libdaemon/libdaemon-${PV}.tar.gz"
SRC_URI[md5sum] = "509dc27107c21bcd9fbf2f95f5669563"
SRC_URI[sha256sum] = "fd23eb5f6f986dcc7e708307355ba3289abe03cc381fc47a80bca4a50aa6b834"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-lynx --disable-doxygen"

