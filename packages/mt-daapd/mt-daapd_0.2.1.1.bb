DESCRIPTION = "multi threaded daap server for POSIX Systems: iTunes Server."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
DEPENDS = "zlib gdbm libid3tag"
PR = "r2"
LICENSE = "GPL"

SRC_URI = "http://optusnet.dl.sourceforge.net/sourceforge/mt-daapd/mt-daapd-0.2.1.1.tar.gz \
	   file://mt-daapd.init"
S = "${WORKDIR}/mt-daapd-0.2.1.1/"

inherit autotools update-rc.d

INITSCRIPT_NAME = "mt-daapd"
INITSCRIPT_PARAMS = "defaults 84"

EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes"

do_install() {
	autotools_do_install
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0644 ${S}contrib/mt-daapd.conf ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/mt-daapd.init ${D}${sysconfdir}/init.d/mt-daapd
}

CONFFILES_${PN} = "${sysconfdir}/mt-daapd.conf" 
