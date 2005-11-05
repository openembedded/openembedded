SECTION = "x11/network"
PR = "r3"

PACKAGES = "prismstumbler prismstumbler-frontend prismstumbler-doc"
DESCRIPTION = "Prismstumbler wireless LAN scanner"
LICENSE = "GPL"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
DEPENDS = "libpcap gtk+ wireless-tools sqlite zlib"
RDEPENDS = "wireless-tools"

SRC_URI = "${SOURCEFORGE_MIRROR}/prismstumbler/${PN}-${PV}.tar.bz2 \
	file://bogoconf.patch;patch=1 \
        file://libz.patch;patch=1;pnum=0"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-libpcap=${STAGING_DIR}/${HOST_SYS} --with-sqlite-libs=${STAGING_LIBDIR} --with-sqlite-includes=${STAGING_INCDIR}"
CFLAGS =+ "-I${S}/include -D_GNU_SOURCE"

FILES_${PN} = "${bindir}/prismstumbler"

FILES_prismstumbler-frontend = "${bindir}/psfront ${bindir}/pst \
	                       ${datadir}/applications \
	                       ${datadir}/pixmaps ${docdir}/prismstumbler/help.txt \
                               ${sysconfdir}"
RDEPENDS_prismstumbler-frontend = "${PN}"

do_configure() {
  autotools_do_configure
  cd ${S}/src/gpsd
  autoreconf
  rm -f Makefile config.log config.cache
  ${S}/src/gpsd/configure \
                    --build=${BUILD_SYS} \
                    --host=${HOST_SYS} \
                    --target=${TARGET_SYS} \
                    --prefix=${prefix} \
                    --exec_prefix=${exec_prefix} \
                    --bindir=${bindir} \
                    --sbindir=${sbindir} \
                    --libexecdir=${libexecdir} \
                    --datadir=${datadir} \
                    --sysconfdir=${sysconfdir} \
                    --sharedstatedir=${sharedstatedir} \
                    --localstatedir=${localstatedir} \
                    --libdir=${libdir} \
                    --includedir=${includedir} \
                    --oldincludedir=${oldincludedir} \
                    --infodir=${infodir} \
                    --mandir=${mandir} \
                        ${EXTRA_OECONF} \
                    $@;
}

do_install_append() {
  chmod a+s ${D}${bindir}/prismstumbler
}
