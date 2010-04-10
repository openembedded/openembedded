DESCRIPTION = "Alternative system logger daemon"
DEPENDS = "libol flex"
PR = "r0"

SRC_URI = "http://www.balabit.com/downloads/files/syslog-ng/sources/1.6/src/${PN}-${PV}.tar.gz \
          file://syslog-ng.conf \
          file://initscript"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR_CROSS}/"

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

SRC_URI[md5sum] = "8f9ca6140f428dc9adec9fa1c270a2dd"
SRC_URI[sha256sum] = "dd37f1e280bd6c2d66c9a15aa3ee9e209a1b649e3b79e70fee58aea1cb0ea093"
