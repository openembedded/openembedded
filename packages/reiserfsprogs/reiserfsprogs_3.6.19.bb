DESCRIPTION = "User-level tools for ReiserFS filesystems"
SECTION = "base"
LICENSE = "GPL"
RRECOMMENDS_${PN} = "reiserfsprogs-reiserfsck reiserfsprogs-mkreiserfs"

SRC_URI = "ftp://ftp.namesys.com/pub/reiserfsprogs/reiserfsprogs-${PV}.tar.gz"
S = "${WORKDIR}/reiserfsprogs-${PV}"

inherit autotools

PACKAGES_prepend = "reiserfsprogs-reiserfsck reiserfsprogs-mkreiserfs "
FILES_reiserfsprogs-reiserfsck = "${sbindir}/reiserfsck"
FILES_reiserfsprogs-mkreiserfs = "${sbindir}/mkreiserfs"
