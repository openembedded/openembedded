DESCRIPTION = "A file-synchronization tool"
HOMEPAGE = "http://www.samba.org/rsync"
SECTION = "console/network"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS += "popt"

inherit autotools

SRC_URI = "http://rsync.samba.org/ftp/rsync/src/rsync-${PV}.tar.gz"

EXTRA_OEMAKE='STRIP=""'

do_install_append() {
	install -d ${D}/etc
	install -m 0644 ${WORKDIR}/rsyncd.conf ${D}/etc
}

