PR = "r9"
DESCRIPTION = "Alternative system logger daemon"
DEPENDS = "libol flex"

SRC_URI = "http://www.balabit.com/downloads/files/syslog-ng/sources/1.6/src/${PN}-${PV}.tar.gz \
          file://syslog-ng.conf \
	  file://initscript"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools update-rc.d

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR_CROSS}/"
CONFFILES_${PN} = "${sysconfdir}/${PN}/syslog-ng.conf"
INITSCRIPT_NAME = "syslog-ng"
INITSCRIPT_PARAMS = "defaults 05"

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

SRC_URI[md5sum] = "ffbad7e8e6dcbe385820b8ffba23b622"
SRC_URI[sha256sum] = "3c841fd89599ffb770cdf2844426980d75dc3dab12e0f707e4cbb51937f6125e"
