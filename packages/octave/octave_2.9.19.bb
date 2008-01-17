require octave.inc

SRC_URI = "ftp://ftp.octave.org/pub/octave/${PN}-${PV}.tar.gz \
           file://configure.patch;patch=1"

PR = "r1"

PACKAGES =+ "libcruft liboctave liboctinterp octave-oct \
	     libcruft-dev liboctave-dev liboctinterp-dev \
             libcruft-dbg liboctave-dbg liboctinterp-dbg"

FILES_libcruft = "${libdir}/${PN}-${PV}/libcruft.so.*"
FILES_libcruft-dev = "${libdir}/${PN}-${PV}/libcruft*"
FILES_libcruft-dbg += "${libdir}/${PN}-${PV}/.debug/libcruft*"

FILES_liboctave = "${libdir}/${PN}-${PV}/liboctave.so.*"
FILES_liboctave-dev = "${libdir}/${PN}-${PV}/liboctave*"
FILES_liboctave-dbg += "${libdir}/${PN}-${PV}/.debug/liboctave*"

FILES_liboctinterp = "${libdir}/${PN}-${PV}/liboctinterp.so.*"
FILES_liboctinterp-dev = "${libdir}/${PN}-${PV}/liboctinterp*"
FILES_liboctinterp-dbg += "${libdir}/${PN}-${PV}/.debug/liboctinterp*"

# octave-oct provides subroutines in .oct file format
FILES_${PN}-oct = "${libexecdir}/${PN}/${PV}/oct/${TARGET_SYS}/*.oct"

FILES_${PN}-dbg += "${libexecdir}/${PN}/${PV}/oct/${TARGET_SYS}/.debug"
