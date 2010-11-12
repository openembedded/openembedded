SECTION = "libs"
DEPENDS = "ncurses fakeroot-native"
LICENSE = "GPL"
DESCRIPTION = "The GNU inetutils are a collection of common \
networking utilities and servers including ftp, ftpd, rcp, \
rexec, rlogin, rlogind, rsh, rshd, syslog, syslogd, talk, \
talkd, telnet, telnetd, tftp, tftpd, and uucpd."

PR = "r7"

SRC_URI = "${GNU_MIRROR}/inetutils/inetutils-${PV}.tar.gz \
"

inherit autotools

EXTRA_OECONF = "--with-ncurses-include-dir=${STAGING_INCDIR}"

do_configure_prepend () {
	cp ${STAGING_DATADIR_NATIVE}/gettext/config.rpath ${S}/build-aux/config.rpath
	rm -f ${S}/glob/configure*
}

fakeroot do_install () {
	autotools_do_install
	install -d ${D}${base_sbindir} ${D}${base_bindir}
	mv ${D}${bindir}/tftp ${D}${bindir}/tftp.${PN}
	mv ${D}${bindir}/telnet ${D}${bindir}/telnet.${PN}
	mv ${D}${bindir}/logger ${D}${bindir}/logger.${PN}
	mv ${D}${bindir}/traceroute ${D}${bindir}/traceroute.${PN}
	mv ${D}${bindir}/hostname ${D}${base_bindir}/hostname.${PN}
	mv ${D}${bindir}/ifconfig ${D}${base_sbindir}/ifconfig.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/tftp tftp tftp.${PN} 100
	update-alternatives --install ${bindir}/telnet telnet telnet.${PN} 100
	update-alternatives --install ${bindir}/logger logger logger.${PN} 100
	update-alternatives --install ${bindir}/traceroute traceroute traceroute.${PN} 100
	update-alternatives --install ${base_bindir}/hostname hostname hostname.${PN} 100
	update-alternatives --install ${base_sbindir}/ifconfig ifconfig ifconfig.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove tftp tftp.${PN}
	update-alternatives --remove telnet telnet.${PN}
	update-alternatives --remove logger logger.${PN}
	update-alternatives --remove traceroute traceroute.${PN}
	update-alternatives --remove ifconfig ifconfig.${PN}
}

SRC_URI[md5sum] = "aeacd11d19bf25c89d4eff38346bdfb9"
SRC_URI[sha256sum] = "345c73b4afd7a4ff8d23af820ccc4d01c4c3ccc01ea9c964c85cdafe5cf11511"
