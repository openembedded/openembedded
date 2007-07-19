DESCRIPTION = "FFTW benchmarks"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "http://www.fftw.org/benchfft/benchfft-${PV}.tar.gz"

EXTRA_OECONF = "--disable-fortran --enable-single --enable-shared"

inherit autotools pkgconfig

do_stage () {
        autotools_stage_all
}

