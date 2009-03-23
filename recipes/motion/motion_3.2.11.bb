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
