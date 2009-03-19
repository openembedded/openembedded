require links.inc

DEPENDS += "virtual/libx11"
RCONFLICTS = "links"
PR = "r1"

SRC_URI += " file://links2.desktop \
             http://www.xora.org.uk/oe/links2.png"

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --without-fb \
	        --without-directfb --without-pmshell --without-atheos \
	        --with-x --without-gpm --without-sdl"

do_install_append() {
        install -d ${D}/${datadir}/applications
        install -m 0644 ${WORKDIR}/links2.desktop ${D}/${datadir}/applications
        install -d ${D}/${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/links2.png ${D}/${datadir}/pixmaps
}

