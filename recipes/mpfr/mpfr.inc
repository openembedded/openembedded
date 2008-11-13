DESCRIPTION = "A C library for multiple-precision floating-point computations with exact rounding"
HOMEPAGE = "http://www.mpfr.org/"
LICENSE = "GPL LGPL"
SECTION = "libs"
BBCLASSEXTEND = "native nativesdk"
INC_PR = "r3"

inherit autotools

do_fixup() {
	rm ${S}/PATCHES || true
}

addtask fixup after do_unpack before do_patch
