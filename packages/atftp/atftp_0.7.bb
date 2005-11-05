DESCRIPTION = "Advanced TFTP server and client"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://packages.debian.org/atftp"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.orig.tar.gz \
	    ${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}-7.diff.gz;patch=1 \
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
