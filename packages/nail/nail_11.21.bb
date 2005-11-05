DESCRIPTION = "Enhanced mailx client."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
DEPENDS = "openssl"
PR = "r1"
LICENSE = "GPL"

SRC_URI = "http://optusnet.dl.sourceforge.net/sourceforge/nail/nail-11.21.tar.bz2 \
	   file://nail.spec.diff;patch=1"
	   
S = "${WORKDIR}/nail-11.21/"

inherit autotools

# EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes"

do_install() {
 	install -d ${D}${bindir} ${D}${mandir} ${D}${sysconfdir}
 	install -m 0755 ${S}nail ${D}${bindir}/nail
 	install -m 0644 ${S}nail.1 ${D}${mandir}/nail.1
 	install -m 0644 ${S}nail.rc ${D}${sysconfdir}/nail.rc
}

CONFFILES_${PN} = "${sysconfdir}/nail.rc"
