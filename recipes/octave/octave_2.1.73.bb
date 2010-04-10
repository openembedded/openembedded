require octave.inc

SRC_URI = "ftp://ftp.octave.org/pub/octave/obsolete/${PN}-${PV}.tar.gz"

PR = "r1"

PACKAGES =+ "libcruft-dev liboctave-dev liboctinterp-dev"

FILES_libcruft-dev = "${libdir}/${PN}-${PV}/libcruft*"
FILES_liboctave-dev = "${libdir}/${PN}-${PV}/liboctave*"
FILES_liboctinterp-dev = "${libdir}/${PN}-${PV}/liboctinterp*"

SRC_URI[md5sum] = "e75a109620e57de081ee73e0489e5990"
SRC_URI[sha256sum] = "d44d23b09165e1d7008dbd4d0e052bb3fa3641de7705c9c0302c9cff583de609"
