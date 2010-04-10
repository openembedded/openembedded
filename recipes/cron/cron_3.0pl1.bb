SECTION = "base"
DESCRIPTION = "Vixie cron."
LICENSE = "cron"
PR ="r8"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/cron${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1 \
	   file://time.patch;patch=1 \
	   file://init"
S = "${WORKDIR}/cron${PV}"

INITSCRIPT_NAME = "cron"
INITSCRIPT_PARAMS = "defaults"
inherit update-rc.d

CFLAGS_append = " -I${S} -DSYS_TIME_H=0"
do_install () {
	install -d ${D}${sbindir} ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}/var/cron/tabs
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/cron
	oe_runmake 'DESTDIR=${D}' install
	chmod ugo+rx ${D}${sbindir}/* ${D}${bindir}/*
}
pkg_postinst() {
        update-rc.d cron defaults 65
}

pkg_postrm() {
	update-rc.d cron remove
}



SRC_URI[md5sum] = "d9f12c3edfca4a4918b8d299cce5f2b4"
SRC_URI[sha256sum] = "99602e966e12347f2728b2153537a14195b06fe130d047e8d91b4f72b24866a0"
