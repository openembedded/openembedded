DESCRIPTION = "Advanced TFTP server and client"
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://packages.debian.org/atftp"
LICENSE = "GPL"
PR = "r7"

SRC_URI = "${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.dfsg.orig.tar.gz;name=archive \
           ${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.dfsg-11.diff.gz;name=patch \
           file://atftpd.init"

S = "${WORKDIR}/atftp-${PV}.dfsg"

inherit autotools update-rc.d

INITSCRIPT_NAME = "atftpd"
INITSCRIPT_PARAMS = "defaults 80"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/atftpd.init ${D}${sysconfdir}/init.d/atftpd
}

SRC_URI[archive.md5sum] = "aa269044a6f992eca78fee2f6119643c"
SRC_URI[archive.sha256sum] = "18815f5b67290fac087c6b9da28dfa5e0feb722096f5c5de52e59b46026da559"
SRC_URI[patch.md5sum] = "1636f199bf32c754a7bf34a5c647d138"
SRC_URI[patch.sha256sum] = "0df33f6c09c2b2de58a84d7bb757844fc9538cd4d6c8d9c463da5270ebc2e41d"
