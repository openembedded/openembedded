DESCRIPTION = "filesystem load benchmark"
HOMEPAGE = "http://samba.org/ftp/tridge/dbench/"
LICENSE = "GPL"

SRC_URI = "http://samba.org/ftp/tridge/dbench/dbench-${PV}.tar.gz \
           file://destdir.patch;patch=1"

inherit autotools
