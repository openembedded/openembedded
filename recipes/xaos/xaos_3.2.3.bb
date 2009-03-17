DESCRIPTION = "GNU XaoS, a realtime fractal generator zoomer"
HOMEPAGE = "http://wmi.math.u-szeged.hu/xaos/doku.php"
SECTION = "graphics"
LICENSE = "GPLv2"
DEPENDS = "aalib libx11 zlib libpng"
RDEPENDS += "libxxf86dga"
PR = "r0"

SRC_URI = "http://easynews.dl.sourceforge.net/sourceforge/xaos/XaoS-3.2.3.tar.gz \
           file://fix-build.patch;patch=1 \
           file://fix-aalib-configure.patch;patch=1"

S = "${WORKDIR}/XaoS-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-nls"
#--with-x --with-ncurses=${STAGING_INCDIR} --with-dga-driver=no --with-x11-driver=no --with-aa-driver=yes

do_configure_prepend() {
    sed -i 's~/usr/include~${STAGING_INCDIR}~' ${S}/configure.in
    sed -i 's~/usr/local/include~${STAGING_INCDIR}~' ${S}/configure.in
    sed -i 's~/usr/lib~${STAGING_LIBDIR}~' ${S}/configure.in
    sed -i 's~/usr/local/lib~${STAGING_LIBDIR}~' ${S}/configure.in
}

FILES_${PN} = "${bindir} ${datadir}/XaoS/catalogs"

CFLAGS = "-L${STAGING_LIBDIR}"
