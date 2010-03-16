require ctorrent.inc

DESCRIPTION += "This is the Enhanced version from the dtorrent project"

SRC_URI = "${SOURCEFORGE_MIRROR}/dtorrent/ctorrent-dnh${PV}.tar.gz \
           file://CVE-2009-1759.patch;patch=1;pnum=0 "

S = "${WORKDIR}/${PN}-dnh${PV}"
PR="r1"
