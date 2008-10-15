require octave.inc

SRC_URI = "ftp://ftp.octave.org/pub/octave/obsolete/${PN}-${PV}.tar.gz"

PR = "r1"

PACKAGES =+ "libcruft-dev liboctave-dev liboctinterp-dev"

FILES_libcruft-dev = "${libdir}/${PN}-${PV}/libcruft*"
FILES_liboctave-dev = "${libdir}/${PN}-${PV}/liboctave*"
FILES_liboctinterp-dev = "${libdir}/${PN}-${PV}/liboctinterp*"
