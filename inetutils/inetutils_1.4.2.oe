SECTION = "libs"
DEPENDS = "ncurses"
LICENSE = "GPL"
DESCRIPTION = "The GNU inetutils are a collection of common \
networking utilities and servers including ftp, ftpd, rcp, \
rexec, rlogin, rlogind, rsh, rshd, syslog, syslogd, talk, \
talkd, telnet, telnetd, tftp, tftpd, and uucpd."

SRC_URI = "${GNU_MIRROR}/inetutils/inetutils-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-ncurses-include-dir=${STAGING_INCDIR}"

do_configure_prepend () {
	rm -f ${S}/glob/configure*
}
