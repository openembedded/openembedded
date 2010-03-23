LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The sysklogd package implements two system log daemons."

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/sysklogd-${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1"

CFLAGS_append = " -DSYSV"
RCONFLICTS = "busybox-syslog"

do_install () {
	install -d ${D}${mandir}/man8 \
		   ${D}${mandir}/man5 \
		   ${D}${base_sbindir}
	oe_runmake 'BINDIR=${D}${base_sbindir}' \
		   'MANDIR=${D}${mandir}' install
    mv ${D}${base_sbindir}/syslogd ${D}${base_sbindir}/syslogd.${PN}
    mv ${D}${base_sbindir}/klogd ${D}${base_sbindir}/klogd.${PN}
    install -d ${D}${sysconfdir}
    install -m 644 ${S}/syslog.conf ${D}${sysconfdir}/syslog.conf
}
pkg_postinst_${PN} () {
    update-alternatives --install ${base_sbindir}/syslogd syslogd syslogd.${PN} 100
    update-alternatives --install ${base_sbindir}/klogd klogd klogd.${PN} 100
}
pkg_prerm_${PN} () {
    update-alternatives --remove syslogd syslogd.${PN}
    update-alternatives --remove klogd klogd.${PN}
}

