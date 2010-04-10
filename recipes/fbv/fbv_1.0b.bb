DESCRIPTION = "Frame Buffer Viewer"
LICENSE = "GPL"
DEPENDS = "libpng jpeg"
PR = "r2"

SRC_URI = "http://s-tech.elsat.net.pl/fbv/fbv-1.0b.tar.gz \
	file://cross_compile.patch;patch=1 \
	file://fbv-1.0b.patch;patch=1 \
	"

do_configure() {
	CC="${CC}" ./configure --without-libungif
}

do_compile() {
	oe_runmake CC="${CC}" \
		CFLAGS="-O2 -Wall -D_GNU_SOURCE -D__KERNEL_STRICT_NAMES"		
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 fbv ${D}${bindir}

# man
	install -d ${D}${mandir}/man1/
	install -m 0644 fbv.1 ${D}${mandir}/man1/fbv.1
}


SRC_URI[md5sum] = "3e466375b930ec22be44f1041e77b55d"
SRC_URI[sha256sum] = "9b55b9dafd5eb01562060d860e267e309a1876e8ba5ce4d3303484b94129ab3c"
