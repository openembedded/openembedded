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

SRC_URI[md5sum] = "df0909a586ddac2b7a0d62795eea4206"
SRC_URI[sha256sum] = "9f001daa0f3d571ae35aac88f04d5dd982a14e90257e4dfb535c143fa18d5830"
