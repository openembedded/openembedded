SECTION = "base"
DESCRIPTION = "Dillon's Cron is a multi-user cron written from scratch, \
similar to vixie-cron but with major differences."
LICENSE = "GPL"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/dcron-${PV}.tar.gz \
	   file://compile.patch;patch=1"

do_install () {
	install -d ${D}${bindir} ${D}${sbindir} \
		   ${D}${mandir}/man1 ${D}${mandir}/man8
	install -m 0755 crond ${D}${sbindir}/
	install -m 4755 crontab ${D}${bindir}/
	install crontab.1 ${D}${mandir}/man1
	install crond.8 ${D}${mandir}/man8
}
