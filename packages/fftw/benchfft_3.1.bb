DESCRIPTION = "FFTW benchmarks"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

# single precision fftw is called fftwf 
DEPENDS = "fftwf"

SRC_URI = "http://www.fftw.org/benchfft/benchfft-${PV}.tar.gz"

EXTRA_OECONF = "--disable-fortran --enable-single --enable-shared"

inherit autotools pkgconfig

do_compile_prepend() {
	sed -i -e 's:all-recursive:$(RECURSIVE_TARGETS):g' ${S}/Makefile
}

do_stage () {
        autotools_stage_all
}

