LICENSE = "GPL"
DESCRIPTION = "A file-synchronization tool"
SECTION = "console/network"
PRIORITY = "optional"
PR = "r1"

SRC_URI = "http://rsync.samba.org/ftp/rsync/rsync-${PV}.tar.gz"

inherit autotools

EXTRA_OEMAKE='STRIP=""'
