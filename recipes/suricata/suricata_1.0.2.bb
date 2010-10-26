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
SRC_URI[md5sum] = "57c93a22602ecc9bbe5857beeb79cb5d"
SRC_URI[sha256sum] = "26865e48cbc15bfed2c7148bc1e8985abe6b01e32f69e61fd3f3e5213f891022"

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
