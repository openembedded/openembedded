DESCRIPTION = "Motion - a motion detection program"
HOMEPAGE = "http://www.lavrsen.dk/twiki/bin/view/Motion/WebHome"
AUTHOR = "Kenneth Lavrsen motion-user@lists.sourceforge.net"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "jpeg ffmpeg mysql postgresql"

RSUGGESTS = "mysql-client postgresql-client"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
           file://ffmpeg-0.4.9.15594svn-20081010.diff;patch=1 "

inherit autotools

EXTRA_OECONF = " --with-ffmpeg=${STAGING_LIBDIR}/../ \
                 --with-mysql-lib=${STAGING_LIBDIR} \
                 --with-mysql-include=${STAGING_INCDIR}/mysql \
                 --with-pgsql-lib=${STAGING_LIBDIR} \
                 --with-pgsql-include=${STAGING_INCDIR} "

SRC_URI[md5sum] = "3a26c00f3250eacf6fa93c7a7e0249d9"
SRC_URI[sha256sum] = "f1e187c61702a727bbd20bf5a66a310363257acc04b1f1c6e0b2e06e9b5dfa6e"
