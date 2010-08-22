DEFAULT_PREFERENCE = "-1"
PR = "${INC_PR}.0"

require octave.inc

SRC_URI = "ftp://ftp.octave.org/pub/octave/${PN}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "90c39fa9e241ad2e978bcee4682a2ba9"
SRC_URI[sha256sum] = "4c0a2cc595dd5218da3144e6599dbaae42a6c2f3188a5e0bc3cc5aaefcfc8fd0"

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

