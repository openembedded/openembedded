SECTION = "libs"
DEPENDS = "ncurses"
LICENSE = "GPL"
DESCRIPTION = "The GNU inetutils are a collection of common \
networking utilities and servers including ftp, ftpd, rcp, \
rexec, rlogin, rlogind, rsh, rshd, syslog, syslogd, talk, \
talkd, telnet, telnetd, tftp, tftpd, and uucpd."

PR = "r2"

SRC_URI = "${GNU_MIRROR}/inetutils/inetutils-${PV}.tar.gz \
"

inherit autotools

EXTRA_OECONF = "--with-ncurses-include-dir=${STAGING_INCDIR}"

do_configure_prepend () {
	cp ${STAGING_DATADIR_NATIVE}/gettext/config.rpath ${S}/build-aux/config.rpath
	rm -f ${S}/glob/configure*
}

do_install () {
	autotools_do_install
	mv ${D}${bindir}/tftp ${D}${bindir}/tftp.${PN}
	mv ${D}${bindir}/telnet ${D}${bindir}/telnet.${PN}
	mv ${D}${bindir}/logger ${D}${bindir}/logger.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/tftp tftp tftp.${PN} 100
	update-alternatives --install ${bindir}/telnet telnet telnet.${PN} 100
	update-alternatives --install ${bindir}/logger logger logger.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove tftp tftp.${PN}
	update-alternatives --remove telnet telnet.${PN}
	update-alternatives --remove logger logger.${PN}
}
