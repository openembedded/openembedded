DESCRIPTION = "User-level tools for NILFS2 filesystems"
SECTION = "base"
LICENSE = "GPL"
HOMEPAGE = "http://www.nilfs.org/"

# required for libuuid
DEPENDS = "util-linux-ng"

RRECOMMENDS_${PN} = "nilfs-utils-mkfs nilfs-utils-stats"

PR = "r0"

SRC_URI ="http://www.nilfs.org/download/nilfs-utils-${PV}.tar.bz2 \
file://no-ldconfig-during-install.patch;patch=1"

S = "${WORKDIR}/nilfs-utils-${PV}"

inherit autotools

PACKAGES_prepend = "nilfs-utils-mkfs nilfs-utils-stats "

FILES_nilfs-utils-mkfs = "${base_sbindir}/mkfs.nilfs2"
FILES_nilfs-utils-stats = "${bindir}/dumpseg ${bindir}/lssu"

SRC_URI[md5sum] = "2621a9f9145c5edfa38e6e5ee79ceca1"
SRC_URI[sha256sum] = "2f79bba49c075c101963aeff8abbf7acc77f489f0b5d7dddb1e5405f48cbd4d4"
