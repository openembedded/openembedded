DESCRIPTION = " dot.conf is an easy to use and powerful configuration file parser library"
HOMEPAGE = "http://www.azzit.de/dotconf/"
LICENSE = "LGPLv2"

PR = "r0"

inherit autotools

SRC_URI = "http://www.azzit.de/dotconf/download/v1.0/dotconf-${PV}.tar.gz \
	  file://srcMakefile.am_00.patch;patch=1"

S = "${WORKDIR}/dotconf-${PV}"

do_install() {
        install -d ${D}${libdir}
        install -d ${D}${includedir}

        install -m 0644 ${S}/src/dotconf.h  ${D}${includedir}
        oe_libinstall -C src -so libdotconf ${D}${libdir}
}

do_stage() {
        install -m 0644 ${S}/src/dotconf.h ${STAGING_INCDIR}/
        oe_libinstall -C src -so libdotconf ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "bbf981a5f4a64e94cc6f2a693f96c21a"
SRC_URI[sha256sum] = "8955fad7d9e7aef36f7a82f9577c3ae4901db1ded6ce57aec0d93e39c8899b65"
