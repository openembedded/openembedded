DESCRIPTION = "Cherokee Web Server fast and secure"
DESCRIPTION_cget = "Small downloader based in the Cherokee client library"
HOMEPAGE = "http://www.cherokee-project.com/"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "libpcre gnutls"
PR = "r0"

SRC_URI = "http://www.cherokee-project.com/download/0.5/${PV}/cherokee-${PV}.tar.gz \
           file://configure.in.patch;patch=1 \
           file://Makefile.am.patch;patch=1 \
           file://cherokee.init"

inherit autotools pkgconfig binconfig update-rc.d

EXTRA_OECONF = "--enable-tls=gnutls --disable-static --disable-nls"

do_install_prepend () {
        # It only needs this app during the install, so compile it natively
        $BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}
do_install_append () {
        install -m 0755 -d ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/cherokee.init ${D}${sysconfdir}/init.d/cherokee
}

PACKAGES =+ "cget libcherokee-server libcherokee-client libcherokee-base"

FILES_cget = "${bindir}/cget"
FILES_libcherokee-server = "${libdir}/libcherokee-server*"
FILES_libcherokee-client = "${libdir}/libcherokee-client*"
FILES_libcherokee-base = "${libdir}/libcherokee-base*"

CONFFILES_${PN} = "${sysconfdir}/cherokee/mime.types \
                   ${sysconfdir}/cherokee/mods-available/admin \
                   ${sysconfdir}/cherokee/mods-available/ssl \
                   ${sysconfdir}/cherokee/advanced.conf \
                   ${sysconfdir}/cherokee/cherokee.conf \
                   ${sysconfdir}/cherokee/mime.compression.types \
                   ${sysconfdir}/cherokee/sites-available/example.com \
                   ${sysconfdir}/cherokee/sites-available/default \
                   ${sysconfdir}/cherokee/icons.conf"

INITSCRIPT_NAME = "cherokee"
INITSCRIPT_PARAMS = "defaults 91 91"
