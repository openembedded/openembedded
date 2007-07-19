DESCRIPTION = "BruteFIR is a software convolution engine, a program for applying long FIR filters to multi-channel digital audio, either offline or in realtime."
LICENSE = "GPLv2"

DEPENDS = "fftw"

SRC_URI = "http://www.ludd.luth.se/~torger/files/brutefir-${PV}.tar.gz \
           file://unbreak-makefile.patch;patch=1 \
	   "

do_configure() {
       sed -i -e s:-L/usr/local/lib:-L${STAGING_LIBDIR}:g Makefile
       sed -i -e s:-I/usr/local/include:-I${STAGING_INCDIR}:g Makefile
}

do_install() {
        install -d ${D}${bindir}
	install -m 755 *.bf* ${D}${bindir}
	install -m 755 brutefir ${D}${bindir}
}

