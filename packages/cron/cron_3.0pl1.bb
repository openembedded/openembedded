SECTION = "base"
DESCRIPTION = "Vixie cron."
LICENSE = "cron"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/cron${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1 \
	   file://time.patch;patch=1"
S = "${WORKDIR}/cron${PV}"

CFLAGS_append = " -I${S} -DSYS_TIME_H=0"
do_install () {
	install -d ${D}${sbindir} ${D}${bindir}
	oe_runmake 'DESTDIR=${D}' install
	chmod ugo+rx ${D}${sbindir}/* ${D}${bindir}/*
}
