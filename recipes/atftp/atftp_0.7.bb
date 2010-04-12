DESCRIPTION = "Advanced TFTP server and client"
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://packages.debian.org/atftp"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.orig.tar.gz;name=archive \
	   ${DEBIAN_MIRROR}/main/a/atftp/atftp_${PV}.dfsg-6.diff.gz;patch=1;name=patch \
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

SRC_URI[archive.md5sum] = "3b27365772d918050b2251d98a9c7c82"
SRC_URI[archive.sha256sum] = "9c548c44d3cfdf259118d9fd4e468e1fe4567456dbff8ff59838c5f70ef62ea3"
SRC_URI[patch.md5sum] = "b5d570affb1412e8e90b9dd24554ad96"
SRC_URI[patch.sha256sum] = "9aa41c8c88ecb1163b7ac69824ac390d6eaaa30ed31a0624486e43f414ec6b7a"
