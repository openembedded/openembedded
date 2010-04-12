DESCRIPTION = "Alternative system logger daemon"
DEPENDS = "libol flex eventlog glib-2.0"
PR = "r2"

SRC_URI = "http://www.balabit.com/downloads/files/syslog-ng/sources/2.0/src/${P}.tar.gz \
          file://syslog-ng.conf \
          file://initscript"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR_CROSS}/ --enable-dynamic-linking"

do_install_append() {
        install -d ${D}/${sysconfdir}/${PN}
        install ${WORKDIR}/syslog-ng.conf ${D}${sysconfdir}/syslog-ng.conf
        install -d ${D}/${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/initscript ${D}/${sysconfdir}/init.d/syslog-ng
}

pkg_postinst() {
        update-rc.d -f syslog remove
}

pkg_postrm() {
        update-rc.d syslog add 5
}

CONFFILES_${PN} = "${sysconfdir}/syslog-ng.conf"

INITSCRIPT_NAME = "syslog-ng"
#INITSCRIPT_PARAMS = "defaults 05"
INITSCRIPT_PARAMS = "remove"

SRC_URI[md5sum] = "c161eefc450fabc246c1a10997c6c6a5"
SRC_URI[sha256sum] = "34862f87d9d404ad4874d95ee871334f5bc2acad65420f672ad2ee286ab660a1"
