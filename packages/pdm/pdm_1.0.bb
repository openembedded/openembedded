SECTION = "x11/base"
LICENSE = "GPL"
DESCRIPTION = "pdm is a minimal session manager for GUIs."

SRC_URI = "http://www.penguru.net/download/pdm-${PV}.tar.gz"

do_install () {
	install -d ${D}${sbindir} \
		   ${D}${sysconfdir}/pdm/sessions \
		   ${D}${sysconfdir}/pdm/plugins
	install -m 0755 pdm ${D}${sbindir}/pdm
	install -m 0644 conf/pdm.conf* ${D}${sysconfdir}/pdm/
}
