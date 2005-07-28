DESCRIPTION = "Advanced TFTP server and client"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://packages.debian.org/atftp"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.mamalinux.com/pub/atftp/atftp-${PV}.tar.gz \
	   file://atftpd.init"
S = "${WORKDIR}/atftp-${PV}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "atftpd"
INITSCRIPT_PARAMS = "defaults 80"

EXTRA_OECONF = ""

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/atftpd.init ${D}${sysconfdir}/init.d/atftpd
}
