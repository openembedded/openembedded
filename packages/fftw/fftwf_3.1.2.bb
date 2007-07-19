DESCRIPTION = "FFTW"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.fftw.org/fftw-${PV}.tar.gz"

EXTRA_OECONF = "--disable-fortran --enable-single --enable-shared"

inherit autotools pkgconfig

S = "${WORKDIR}/fftw-${PV}"


do_stage () {
        autotools_stage_all
}

