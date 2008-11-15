DESCRIPTION = "multi threaded daap server for POSIX Systems: iTunes Server."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "zlib gdbm libid3tag \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libid3tag', d)}"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
	   file://${PN}.init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults 84"

EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes"

do_install() {
	autotools_do_install
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0644 ${S}/contrib/${PN}.conf ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/${PN}.init ${D}${sysconfdir}/init.d/${PN}
}

CONFFILES_${PN} = "${sysconfdir}/${PN}.conf" 
