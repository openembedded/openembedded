LICENSE = GPL
DESCRIPTION = "A file-synchronization tool"
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "http://rsync.samba.org/ftp/rsync/rsync-${PV}.tar.gz"

inherit autotools

EXTRA_OEMAKE='STRIP=""'
