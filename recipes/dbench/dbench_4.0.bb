DESCRIPTION = "The dbench (disk) and tbench (TCP) benchmarks"
DESCRIPTION_dbench = "Filesystem load benchmark"
DESCRIPTION_tbench = "TCP load benchmark"
HOMEPAGE = "http://samba.org/ftp/tridge/dbench/"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "\
  http://samba.org/ftp/tridge/dbench/dbench-${PV}.tar.gz \
  file://destdir.patch;patch=1 \
  file://makefile.patch;patch=1"

inherit autotools

PACKAGES =+ "tbench tbench-dbg"

FILES_tbench = "${bindir}/tbench*"
FILES_tbench-dbg += "${bindir}/.debug/tbench*"

SRC_URI[md5sum] = "1fe56ff71b9a416f8889d7150ac54da4"
SRC_URI[sha256sum] = "6001893f34e68a3cfeb5d424e1f2bfef005df96a22d86f35dc770c5bccf3aa8a"
