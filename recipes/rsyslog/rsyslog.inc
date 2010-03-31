DESCRIPTION = "Rsyslog is an enhanced multi-threaded syslogd"
DEPENDS = "zlib"
HOMEPAGE = "http://www.rsyslog.com/"
LICENSE = "GPLv3"
INC_PR = "r0"

SRC_URI = "http://download.rsyslog.com/rsyslog/${PN}-${PV}.tar.gz;name=archive \
          file://rsyslog.conf \
          file://initscript"

inherit autotools update-rc.d

do_install_append() {
        install -d ${D}/${sysconfdir}/${PN}
        install ${WORKDIR}/rsyslog.conf ${D}${sysconfdir}/rsyslog.conf
        install -d ${D}/${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/initscript ${D}/${sysconfdir}/init.d/rsyslog
}

pkg_postinst() {
        update-rc.d -f syslog remove
}

pkg_postrm() {
        update-rc.d syslog add 5
}

CONFFILES_${PN} = "${sysconfdir}/rsyslog.conf"

INITSCRIPT_NAME = "rsyslog"
#INITSCRIPT_PARAMS = "defaults 05"
INITSCRIPT_PARAMS = "remove"
