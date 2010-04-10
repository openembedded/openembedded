SECTION = "base"
DESCRIPTION = "Dillon's Cron is a multi-user cron written from scratch, \
similar to vixie-cron but with major differences."
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/dcron-${PV}.tar.gz \
	   file://compile.patch;patch=1 \
	   file://strip.patch;patch=1"

do_install () {
	install -d ${D}${bindir} ${D}${sbindir} \
		   ${D}${mandir}/man1 ${D}${mandir}/man8
	install -m 0755 crond ${D}${sbindir}/
	install -m 4755 crontab ${D}${bindir}/
	install crontab.1 ${D}${mandir}/man1
	install crond.8 ${D}${mandir}/man8
}

SRC_URI[md5sum] = "537cda2dff7dfaf87660fee91b2cf78f"
SRC_URI[sha256sum] = "bd7ce3b854678209e8624698a4000d3e5337339c3825c58a4b3a0a2fbf1a7819"
