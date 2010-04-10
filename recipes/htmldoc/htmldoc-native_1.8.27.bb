require htmldoc.inc
PR = "r2"


SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/htmldoc/${PV}/htmldoc-${PV}-source.tar.bz2 \
file://paths_1.8.27.patch;patch=1"


inherit autotools native

EXTRA_AUTORECONF += "--exclude=autoheader"
EXTRA_OECONF += "--disable-localpng --disable-localjpeg --disable-localzlib \
		--with-gui=no"


do_compile() {
	cd htmldoc && oe_runmake all ; cd ${S}
}


do_stage () {
	install -d ${STAGING_DATADIR}/htmldoc/fonts
	install -m 0644 ${S}/fonts/*.afm ${STAGING_DATADIR}/htmldoc/fonts/
	install -m 0644 ${S}/fonts/*.pfa ${STAGING_DATADIR}/htmldoc/fonts/

	install -d ${STAGING_DATADIR}/htmldoc/data
	install -m 0644 ${S}/data/* ${STAGING_DATADIR}/htmldoc/data/

	install -d ${STAGING_DIR_HOST}${layout_mandir}/man1
	install -m 0644 ${S}/doc/htmldoc.man ${STAGING_DIR_HOST}${layout_mandir}/man1/

	install -d ${STAGING_BINDIR}
	install -m 0755 ${S}/htmldoc/htmldoc ${STAGING_BINDIR}/
}

SRC_URI[md5sum] = "35589e7b8fe9c54e11be87cd5aec4dcc"
SRC_URI[sha256sum] = "89ffd223734268375dc959c200622dc5f167576c5cad9d7ce4bd7567faeb9613"
