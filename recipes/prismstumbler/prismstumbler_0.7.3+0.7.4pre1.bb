SECTION = "x11/network"
PR = "r4"

PACKAGES = "${PN}-dbg prismstumbler prismstumbler-frontend prismstumbler-doc"
DESCRIPTION = "Prismstumbler wireless LAN scanner"
DESCRIPTION_prismstumbler-frontend = "Prismstumbler wireless LAN scanner GTK frontend"
LICENSE = "GPL"
DEPENDS = "libpcap gtk+ wireless-tools sqlite zlib dbus-glib gpsd"
RDEPENDS = "wireless-tools"
RRECOMMENDS = "gpsd"

# wireless.patch is required for linux-libc-headers == 2.6.23
# but breaks build with linux-libc-headers >= 2.6.30.
SRC_URI = "http://projects.linuxtogo.org/frs/download.php/14/${PN}-0.7.4pre1.tar.gz \
           file://gpsapi.patch;patch=1 \
      ${@['', 'file://wireless.patch;patch=1'][bb.data.getVar('PREFERRED_VERSION_linux-libc-headers', d, 1) and bb.data.getVar('PREFERRED_VERSION_linux-libc-headers', d, 1).split('.')[2] < '30']} \
           file://fix-includes.patch;patch=1;pnum=0 \
           file://libgps-check.patch;patch=1"

S = "${WORKDIR}/${PN}-0.7.4pre1"

inherit autotools pkgconfig

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
		--x-libraries=${STAGING_LIBDIR} \
		--with-libpcap=${STAGING_EXECPREFIXDIR} \
		--with-sqlite-includes=${STAGING_INCDIR} \
		--with-sqlite-libs=${STAGING_LIBDIR} \
		--without-athena --enable-dbus \
                --with-libiw=${STAGING_EXECPREFIXDIR}"
CFLAGS =+ "-I${S}/include"
LDFLAGS += "-lz"

# Ugly hack to find libstdc++ for libgps
EXTRA_OEMAKE_append = 'CCLD="${CXX}"'

FILES_${PN} = "${bindir}/prismstumbler"

FILES_prismstumbler-frontend = "${bindir}/psfront ${bindir}/pst \
	                       ${datadir}/applications \
	                       ${datadir}/pixmaps ${docdir}/prismstumbler/help.txt \
                               ${sysconfdir}"
RDEPENDS_prismstumbler-frontend = "${PN}"


do_install_append() {
  chmod a+s ${D}${bindir}/prismstumbler
}

SRC_URI[md5sum] = "5b2e91311c94579e4f5e1d4fdd9bc4fe"
SRC_URI[sha256sum] = "81d536d5307b8d5b96587ff673e69b9e5049d11d56643b3ea6984b31baa0ab56"
