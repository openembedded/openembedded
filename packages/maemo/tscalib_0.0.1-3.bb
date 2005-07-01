PR         = "r0"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DEPENDS    = "virtual/xserver tslib"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/t/${PN}/${PN}_${PV}.tar.gz \
           file://makefile.patch;patch=1;pnum=0"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

do_compile () {
	oe_runmake PREFIX=${prefix}
}

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}
