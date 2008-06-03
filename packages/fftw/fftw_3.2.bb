require fftw.inc

PV = "3.1.2+3.2alpha3"

SRC_URI = "http://www.fftw.org/fftw-3.2alpha3.tar.gz"

S = "${WORKDIR}/fftw-3.2alpha3"

EXTRA_OECONF = "--disable-fortran --enable-shared"


