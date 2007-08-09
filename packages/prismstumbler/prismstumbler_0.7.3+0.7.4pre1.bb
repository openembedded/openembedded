SECTION = "x11/network"
PR = "r3"

PACKAGES = "prismstumbler prismstumbler-frontend prismstumbler-doc"
DESCRIPTION = "Prismstumbler wireless LAN scanner"
DESCRIPTION_prismstumbler-frontend = "Prismstumbler wireless LAN scanner GTK frontend"
LICENSE = "GPL"
DEPENDS = "libpcap gtk+ wireless-tools sqlite zlib dbus-glib gpsd"
RDEPENDS = "wireless-tools"
RRECOMMENDS = "gpsd"

SRC_URI = "http://projects.linuxtogo.org/frs/download.php/14/${PN}-0.7.4pre1.tar.gz \
           file://gpsapi.patch;patch=1 \
           file://wireless.patch;patch=1 \
           file://fix-includes.patch;patch=1;pnum=0"

S = "${WORKDIR}/${PN}-0.7.4pre1"

inherit autotools pkgconfig

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
		--x-libraries=${STAGING_LIBDIR} \
		--with-libgps=${STAGING_DIR}/${HOST_SYS} \
		--with-libpcap=${STAGING_DIR}/${HOST_SYS} \
		--with-sqlite-includes=${STAGING_INCDIR} \
		--with-sqlite-libs=${STAGING_LIBDIR} \
		--without-athena --enable-dbus \
                --with-libiw=${STAGING_DIR}/${HOST_SYS}"

CFLAGS =+ "-I${S}/include"
LDFLAGS += "-lz"

FILES_${PN} = "${bindir}/prismstumbler"

FILES_prismstumbler-frontend = "${bindir}/psfront ${bindir}/pst \
	                       ${datadir}/applications \
	                       ${datadir}/pixmaps ${docdir}/prismstumbler/help.txt \
                               ${sysconfdir}"
RDEPENDS_prismstumbler-frontend = "${PN}"


do_install_append() {
  chmod a+s ${D}${bindir}/prismstumbler
}
