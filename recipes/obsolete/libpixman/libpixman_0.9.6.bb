SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"
SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz"
S = "${WORKDIR}/pixman-${PV}"

inherit autotools pkgconfig

do_stage () {
 	autotools_stage_all
}


SRC_URI[md5sum] = "d2b1071cdbb0b8da18039111ba2dfd22"
SRC_URI[sha256sum] = "179abc613f5100081cdef833f24a35fe7b646b8a4f0c79647d9609f6bf8222d8"
