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
