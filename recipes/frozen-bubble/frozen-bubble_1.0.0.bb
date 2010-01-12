LICENSE = "GPL"
SECTION = "games"
DEPENDS = "libsdl-mixer libsdl-image sdl-perl"
RDEPENDS_${PN} = "${PN}-data perl sdl-perl \
                  perl-module-strict perl-module-vars \
                  perl-module-getopt-long perl-module-exporter-heavy \
                  perl-module-data-dumper \
                  perl-module-bytes liblocale-gettext-perl \
                  perl-module-dynaloader perl-module-posix \
                  perl-module-autoloader perl-module-math-trig \
                  perl-module-io-file perl-module-io \
                  perl-module-file-spec-unix perl-module-time-hires \
                  perl-module-io-socket perl-module-io-select \
                  perl-module-file-glob \
                 "
PR = "r1"

SRC_URI = "http://zarb.org/~gc/fb//frozen-bubble-${PV}.tar.bz2 \
	file://Makefile_top.patch;patch=1 \
	file://Makefile.patch;patch=1 \
	file://Makefile.PL.patch;patch=1"
# The Makefile needs to be patched to look in STAGING_LIBDIR/perl/... - It's looking in i686-linux/lib at the moment, regardless of arch
BROKEN = "1"


do_compile() {
	oe_runmake OPTIMIZE="${CFLAGS}" PREFIX="${prefix}"
}

do_install() {
	oe_runmake PREFIX="${D}${prefix}" install
}
