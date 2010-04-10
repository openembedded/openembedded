DESCRIPTION = "User-level tools for ReiserFS filesystems"
SECTION = "base"
LICENSE = "GPL"
RRECOMMENDS_${PN} = "reiserfsprogs-reiserfsck reiserfsprogs-mkreiserfs"
PR = "r1"

#Namesys.com seems to be in trouble.  See bug #3482 for more information
#SRC_URI ="ftp://ftp.namesys.com/pub/reiserfsprogs/reiserfsprogs-${PV}.tar.gz \
SRC_URI ="${DEBIAN_MIRROR}/main/r/reiserfsprogs/reiserfsprogs_${PV}.orig.tar.gz \
	  file://header-fix.patch;patch=1 \
	  "

S = "${WORKDIR}/reiserfsprogs-${PV}"

inherit autotools

PACKAGES_prepend = "reiserfsprogs-reiserfsck reiserfsprogs-mkreiserfs "
FILES_reiserfsprogs-reiserfsck = "${sbindir}/reiserfsck"
FILES_reiserfsprogs-mkreiserfs = "${sbindir}/mkreiserfs"

SRC_URI[md5sum] = "b42cf15f6651c3ceff5cb84996c0d539"
SRC_URI[sha256sum] = "c0862c53aecd23724a72d32fb54706d61d9858925c78408a2852d042417e68bf"
