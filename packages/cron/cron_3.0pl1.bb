SECTION = "base"
DESCRIPTION = "Vixie cron."
LICENSE = "cron"
PR="r3"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/cron${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1 \
	   file://time.patch;patch=1 \
	   file://install-sh \
	   file://init"
S = "${WORKDIR}/cron${PV}"

CFLAGS_append = " -I${S} -DSYS_TIME_H=0"
do_install () {
	install -d ${D}${sbindir} ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}/var/cron/tabs
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/cron
	# This will make the -s option work somewhat portably cross
	# platform
	STRIPPROG="$STRIP" oe_runmake 'DESTDIR=${D}' INSTALL="${WORKDIR}/install-sh" install
	chmod ugo+rx ${D}${sbindir}/* ${D}${bindir}/*
}
