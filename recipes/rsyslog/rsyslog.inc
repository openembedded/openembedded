DESCRIPTION = "Rsyslog is an enhanced multi-threaded syslogd"
DEPENDS = "zlib"
HOMEPAGE = "http://www.rsyslog.com/"
LICENSE = "GPLv3"
INC_PR = "r3"

SRC_URI = "http://www.rsyslog.com/files/download/rsyslog/${PN}-${PV}.tar.gz \
          file://rsyslog.conf \
          file://initscript"


inherit autotools

do_install_append() {
        install -d ${D}/${sysconfdir}/rsyslog.d
        install ${WORKDIR}/rsyslog.conf ${D}${sysconfdir}/rsyslog.conf
        install -d ${D}/${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/initscript ${D}/${sysconfdir}/init.d/syslog.${PN}
}

# syslog initscript is handled explicitly because order of
# update-rc.d and update-alternatives is important
DEPENDS_append = " update-rc.d update-rc.d-native"
RDEPENDS_${PN}_append = " ${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "update-rc.d", d)}"

pkg_postinst_${PN} () {
	update-alternatives --install ${sysconfdir}/init.d/syslog syslog-init syslog.${PN} 300

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

CONFFILES_${PN} = "${sysconfdir}/rsyslog.conf"

INITSCRIPT_NAME = "syslog"
