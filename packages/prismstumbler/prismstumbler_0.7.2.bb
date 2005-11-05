SECTION = "x11/network"
PR = "r1"

PACKAGES = "prismstumbler prismstumbler-frontend"
DESCRIPTION = "Prismstumbler wireless LAN scanner"
LICENSE = "GPL"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
DEPENDS = "libpcap gtk+ wireless-tools sqlite"


SRC_URI = "${SOURCEFORGE_MIRROR}/prismstumbler/${PN}-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = ""
CFLAGS =+ "-I${S}/include"

FILES_${PN} = "${bindir}/prismstumbler"

FILES_prismstumbler-frontend = "${bindir}/psfront ${bindir}/pst \
	                       ${datadir}/applications \
	                       ${datadir}/pixmaps ${docdir}/prismstumbler/help.txt \
                               ${sysconfdir}"

do_configure() {
  cd ${S};
  oe_runconf;
  cd ${S}/src/gpsd;
  rm Makefile;
  rm config.log;
  rm config.cache;
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
