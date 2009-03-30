SECTION = "x11/base"
LICENSE = "GPL"
DESCRIPTION = "pdm is a minimal session manager for GUIs."

SRC_URI="http://www.penguru.net/download/${PN}-${PV}.tar.gz \
	file://pdm-1.0-changes.patch;patch=1 \
	file://pdm.conf \
	file://xfce \
	file://mythtv"

do_install() {
	install -d ${D}${sbindir} \
		   ${D}${sysconfdir}/pdm/sessions \
		   ${D}${sysconfdir}/pdm/plugins

	install -m 0755 pdm ${D}${sbindir}/pdm
	install -m 0644 conf/pdm.conf* ${D}${sysconfdir}/pdm/
	install -m 0644 ${WORKDIR}/pdm.conf ${D}${sysconfdir}/pdm/
	install -m 755 ${WORKDIR}/xfce ${D}${sysconfdir}/pdm/sessions/xfce
	install -m 755 ${WORKDIR}/mythtv ${D}${sysconfdir}/pdm/sessions/mythtv
}
