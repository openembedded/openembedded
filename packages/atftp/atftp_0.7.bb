DESCRIPTION = "Advanced TFTP server and client"
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://packages.debian.org/atftp"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.orig.tar.gz \
	    ${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.dfsg-3.diff.gz;patch=1 \
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
