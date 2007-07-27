DESCRIPTION = "FFTW"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "http://www.fftw.org/fftw-${PV}.tar.gz"

S = "${WORKDIR}/fftw-${PV}"

inherit autotools pkgconfig

do_configure_prepend() {
        echo 'AM_PROG_AS' >> ${S}/configure.ac 
}

do_stage () {
        autotools_stage_all
}


PACKAGES =+ "lib${PN}"

FILES_lib${PN} = "${libdir}/lib*.so.*"

# rename binary in /bin and use u-a tpo choose between different precision implementations?
