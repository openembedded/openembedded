PR         = "r0"
LICENSE    = "GPL"
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

SRC_URI[md5sum] = "a06f80dfda9688e033561f959aae2d5e"
SRC_URI[sha256sum] = "b27add2e28f38feea0c554633f220cd7542a8bb768ba290636a317852774ecbb"
