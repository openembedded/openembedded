DESCRIPTION = "Small, fast and powerful xml library"
AUTHOR = "Tristan Lelong <tristan.lelong@libroxml.net>"
HOMEPAGE = "http://www.libroxml.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1+"
INC_PR = "r0"

SRC_URI = "http://libroxml.googlecode.com/files/${P}.tar.gz"

do_install() {
	install -D -m 755 ${S}/roxml ${D}/${bindir}/roxml
	install -D -m 755 ${S}/libroxml.so.0 ${D}/${libdir}/libroxml.so.0
	install -D -m 644 ${S}/libroxml.a ${D}/${libdir}/libroxml.a
	install -D -m 644 ${S}/inc/roxml.h ${D}/${includedir}/roxml.h
	ln -s libroxml.so.0 ${D}/${libdir}/libroxml.so
}

PACKAGES =+ "roxml roxml-dbg"
FILES_roxml = "${bindir}/*"
FILES_roxml-dbg = "${bindir}/.debug/*"
