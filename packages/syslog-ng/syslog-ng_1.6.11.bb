DESCRIPTION = "Alternative system logger daemon"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
DEPENDS = "libol flex"
PR = "r0"

SRC_URI = "http://www.balabit.com/downloads/syslog-ng/1.6/src/${PN}-${PV}.tar.gz \
          file://syslog-ng.conf \
          file://initscript"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR}/"

do_install_append() {
        install -d ${D}/${sysconfdir}/${PN}
        install ${WORKDIR}/syslog-ng.conf ${D}${sysconfdir}/${PN}/syslog-ng.conf
        install -d ${D}/${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/initscript ${D}/${sysconfdir}/init.d/syslog-ng
}

pkg_postinst() {
        update-rc.d -f syslog remove
}

pkg_postrm() {
        update-rc.d syslog add 5
}

CONFFILES_${PN} = "${sysconfdir}/${PN}/syslog-ng.conf"

INITSCRIPT_NAME = "syslog-ng"

INITSCRIPT_PARAMS = "defaults 05"
