DESCRIPTION = "FFTW"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = ""
PR = "r0"

SRC_URI = "http://www.fftw.org/fftw-3.1.2.tar.gz"

inherit autotools

EXTRA_OECONF = "--enable-single --enable-shared --disable-fortran"

do_stage () {
	autotools_stage_all
}

