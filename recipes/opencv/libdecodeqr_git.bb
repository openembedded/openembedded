DESCRIPTION = "A C/C++ library for decoding QR code 2D barcodes"
LICENSE = "LGPLv2.1"

DEPENDS = "opencv"

PE = "1"
PV = "0.9.4"
PR = "r1+gitr${SRCREV}"

inherit autotools lib_package

SRCREV = "7e6896d78d857fada4b8"
SRC_URI = "git://github.com/josephholsten/libdecodeqr.git;protocol=git"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/examples/simple/.libs/simpletest ${D}${bindir}/libdecodeqr-simpletest
	install -m 0755 ${S}/examples/webcam/.libs/webcam ${D}${bindir}/libdecodeqr-webcamtest
}

