require fftw.inc

SRC_URI = "http://www.fftw.org/fftw-${PV}.tar.gz"

EXTRA_OECONF = "--disable-fortran --enable-long-double --enable-shared"


