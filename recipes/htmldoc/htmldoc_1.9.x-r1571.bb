require htmldoc.inc
BBCLASSEXTEND = "native"
DEPENDS += "htmldoc-native"
DEPENDS_virtclass-native = ""
PR = "r3"


SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/htmldoc/snapshots/htmldoc-${PV}.tar.bz2 \
file://paths_1.9.x.patch"


inherit autotools pkgconfig

EXTRA_AUTORECONF += "--exclude=autoheader"
EXTRA_OECONF += "--disable-localpng --disable-localjpeg --disable-localzlib \
		--with-gui=no"

FILES_${PN} += "${datadir}/htmldoc/fonts"
FILES_${PN} += "${datadir}/htmldoc/data"


do_install() {
	oe_runmake 'DESTDIR=${D}' install
}

do_compile_virtclass-native() {
	cd htmldoc && oe_runmake all ; cd ${S}
}

do_install_virtclass-native() {
	install -d ${D}${datadir}/htmldoc/fonts
	install -m 0644 ${S}/fonts/*.afm ${D}${datadir}/htmldoc/fonts/
	install -m 0644 ${S}/fonts/*.pfa ${D}${datadir}/htmldoc/fonts/

	install -d ${D}${datadir}/htmldoc/data
	install -m 0644 ${S}/data/* ${D}${datadir}/htmldoc/data/

	install -d ${D}${bindir}
	install -m 0755 ${S}/htmldoc/htmldoc ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"

SRC_URI[md5sum] = "eda75ba1abe14ed8e71c6f40438def85"
SRC_URI[sha256sum] = "b4c78ff6b47521e980533e52cbe46fe86874c75b3d6bc18bcc2500a2ba854c3e"
