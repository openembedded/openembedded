DESCRIPTION = "The Suricata Engine is an Open Source Next Generation Intrusion Detection and Prevention Engine"
LICENSE = "GPLv2"
HOMEPAGE = "http://openinfosecfoundation.org/"
DEPENDS = "libhtp libyaml libprelude libnetfilter-queue libnet libpcap libpcre libpfring"

PR = "r1"

SRC_URI = " \
	http://www.openinfosecfoundation.org/download/suricata-${PV}.tar.gz \
	file://volatiles \
	file://logrotate \
	file://default \
	file://init \
	"
SRC_URI[md5sum] = "ad42b854ef2b44499f0f1d1531b1ca36"
SRC_URI[sha256sum] = "7fbc8fe89a0a30171eddb8b066ab7e6ec811d14a73aa6bc9cea26fc1f36f4be4"

EXTRA_OECONF = " \
	--enable-nfqueue \
	--enable-prelude \
	--enable-pfring \
	--enable-non-bundled-htp \
	--with-libnet-includes=${STAGING_INCDIR} \
	--with-libnet-libraries=${STAGING_LIBDIR} \
	"

inherit autotools

do_install_append() {
	install -d ${D}${sysconfdir}/default/volatiles
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/logrotate.d
	install -d ${D}${sysconfdir}/suricata
	install -m 0644 suricata.yaml ${D}${sysconfdir}/suricata/
	install -m 0644 classification.config ${D}${sysconfdir}/suricata/
	install -m 0644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/suricata
	install -m 0644 ${WORKDIR}/logrotate ${D}${sysconfdir}/logrotate.d/suricata
	install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default/suricata
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/suricata
}

pkg_postinst_${PN}() {
	${sysconfdir}/init.d/populate-volatile.sh update
}

PACKAGES =+ "${PN}-logrotate"
FILES_${PN}-logrotate = "${sysconfdir}/logrotate.d/suricata"
RRECOMMENDS_${PN} += "${PN}-logrotate"
RSUGGESTS_${PN}-logrotate += "logrotate"

CONFFILES_${PN} = " \
	${sysconfdir}/default/suricata \
	${sysconfdir}/suricata/suricata.yaml \
	${sysconfdir}/suricata/classification.config \
	"