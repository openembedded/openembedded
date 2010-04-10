require octave.inc

PR = "r2"

SRC_URI = "ftp://ftp.octave.org/pub/octave/${PN}-${PV}.tar.gz \
           file://configure.patch;patch=1"

PACKAGES =+ "libcruft liboctave liboctinterp octave-oct \
	     libcruft-dev liboctave-dev liboctinterp-dev \
             libcruft-dbg liboctave-dbg liboctinterp-dbg"

FILES_libcruft = "${libdir}/${PN}-${PV}/libcruft.so*"
FILES_libcruft-dbg += "${libdir}/${PN}-${PV}/.debug/libcruft*"

FILES_liboctave = "${libdir}/${PN}-${PV}/liboctave.so*"
FILES_liboctave-dbg += "${libdir}/${PN}-${PV}/.debug/liboctave*"

FILES_liboctinterp = "${libdir}/${PN}-${PV}/liboctinterp.so*"
FILES_liboctinterp-dbg += "${libdir}/${PN}-${PV}/.debug/liboctinterp*"

# octave-oct provides subroutines in .oct file format
FILES_${PN}-oct = "${libexecdir}/${PN}/${PV}/oct/${TARGET_SYS}/*.oct"

FILES_${PN}-dbg += "${libexecdir}/${PN}/${PV}/oct/${TARGET_SYS}/.debug"

SRC_URI[md5sum] = "6b11065c9dbd3c9743d234c2f785fb7b"
SRC_URI[sha256sum] = "fb093e267e5b9656f767896a33d664e5ee921e28898a481542bdb4db31f7604e"
