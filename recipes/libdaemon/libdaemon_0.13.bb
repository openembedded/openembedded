DESCRIPTION = "libdaemon is a lightweight C library that eases the writing of UNIX daemons."
SECTION = "libs"
AUTHOR = "Lennart Poettering <lennart@poettering.net>"
HOMEPAGE = "http://0pointer.de/lennart/projects/libdaemon/"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "http://0pointer.de/lennart/projects/libdaemon/libdaemon-${PV}.tar.gz"

inherit autotools_stage pkgconfig

EXTRA_OECONF = "--disable-lynx --disable-doxygen"

SRC_URI[md5sum] = "ae9113fcd825d5a7f07e5ddccb3c3102"
SRC_URI[sha256sum] = "bd949d459d2da54f1cdfbd1f4592e32541e8a195aca56fa7a8329ed79836d709"
