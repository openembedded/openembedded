DESCRIPTION = "Frame Buffer Viewer"
LICENSE = "GPL"
DEPENDS = "libpng"
PR = "r1"

SRC_URI = "http://s-tech.elsat.net.pl/fbv/fbv-1.0b.tar.gz \
	   file://cross_compile.patch;patch=1"

do_configure() {
	CC="${CC}" ./configure --without-libungif --without-bmp \
		--without-libjpeg
}

do_compile() {
	oe_runmake CFLAGS="-O2 -Wall -D_GNU_SOURCE -D__KERNEL_STRICT_NAMES" \
		CC="${CC}"
}
do_install() {
	install -d ${D}${bindir}
        install -m 0755 fbv ${D}${bindir}

        # man
        install -d ${D}${mandir}/man1/
        install -m 0644 fbv.1 ${D}${mandir}/man1/fbv.1
}
