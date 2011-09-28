require fftw.inc

SRC_URI = "http://www.fftw.org/fftw-${PV}-beta1.tar.gz"

EXTRA_OECONF = "--disable-fortran --enable-single --enable-shared --enable-threads"
EXTRA_OECONF_append_armv7a = " --enable-neon"

S="${WORKDIR}/fftw-${PV}-beta1"

SRC_URI[md5sum] = "905283dfc134e1aa6447a1cfef6c8c29"
SRC_URI[sha256sum] = "d346c272b0aae61500bcddcb05a03a25808ff5176f4df0ad407c1d730bf314a2"
