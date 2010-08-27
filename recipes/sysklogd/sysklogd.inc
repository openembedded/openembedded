LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The sysklogd package implements two system log daemons."
INC_PR = "r4"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/sysklogd-${PV}.tar.gz \
	       file://nonrootinstall.patch \
           file://sysklogd"

# syslog initscript is handled explicitly because order of
# update-rc.d and update-alternatives is important (see below)
DEPENDS_append = " update-rc.d update-rc.d-native"
RDEPENDS_${PN}_append = " ${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "update-rc.d", d)}"

INITSCRIPT_NAME = "syslog"

CFLAGS_append = " -DSYSV"

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
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/sysklogd ${D}${sysconfdir}/init.d/syslog.${PN}
}

pkg_preinst_${PN} () {
    # all this is needed to avoid sysmlink errors,
    # because update-rc.d runs before pkg_postinst :(
    if [ -e ${sysconfdir}/init.d/syslog -a ! -L ${sysconfdir}/init.d/syslog ]; then
        echo "WARNING:" "non symlink ${sysconfdir}/init.d/syslog exist -> backup to ${sysconfdir}/init.d/syslog.old"
        mv ${sysconfdir}/init.d/syslog ${sysconfdir}/init.d/syslog.old
    fi
    if [ ! -e ${sysconfdir}/init.d/syslog ]; then
        ln -s dummy ${sysconfdir}/init.d/syslog
    fi
}

pkg_postinst_${PN} () {
    update-alternatives --install ${base_sbindir}/syslogd syslogd syslogd.${PN} 100
    update-alternatives --install ${base_sbindir}/klogd klogd klogd.${PN} 100
    update-alternatives --install ${sysconfdir}/init.d/syslog syslog-init syslog.${PN} 100

    if test "x$D" != "x"; then
	OPT="-r $D"
    else
	OPT="-s"
    fi
    # remove all rc.d-links potentially created from alternative
    # syslog packages before creating new ones
    update-rc.d $OPT -f syslog remove
    update-rc.d $OPT syslog start 20 2 3 4 5 . stop 90 0 1 6 .
}

pkg_prerm_${PN} () {
    update-alternatives --remove syslogd syslogd.${PN}
    update-alternatives --remove klogd klogd.${PN}

    if test "x$D" = "x"; then
	if test "$1" = "upgrade" -o "$1" = "remove"; then
	    /etc/init.d/syslog stop
	fi
    fi
    update-alternatives --remove syslog-init syslog.${PN}
}

pkg_postrm_${PN} () {
    if test "x$D" != "x"; then
	OPT="-r $D"
    else
	OPT=""
    fi
    if test "$1" = "remove" -o "$1" = "purge"; then
	if ! test -e "/etc/init.d/syslog"; then
	    update-rc.d $OPT syslog remove
	fi
    fi
}
