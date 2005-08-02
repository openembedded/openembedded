SECTION = "base"
DESCRIPTION = "Vixie cron."
LICENSE = "cron"
PR="r5"
DEPENDS += "install-native"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/cron${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1 \
	   file://time.patch;patch=1 \
	   file://init"
S = "${WORKDIR}/cron${PV}"

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
		

