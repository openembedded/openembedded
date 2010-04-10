DESCRIPTION = "libdvdread provides a simple foundation for reading DVD video disks. \
It provides the functionality that is required to access many DVDs. \
It parses IFO files, reads NAV-blocks, and performs CSS authentication and descrambling."
HOMEPAGE = "http://www.dtek.chalmers.se/groups/dvd/development.shtml"
LICENSE = "GPL"
DEPENDS = "libdvdcss"
SECTION = "libs/multimedia"

PR = "r1"

SRC_URI = "http://www.dtek.chalmers.se/groups/dvd/dist/libdvdread-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " --with-libdvdcss-includes=${STAGING_INCDIR} \
                 --with-libdvdcss-libs=${STAGING_LIBDIR} \
"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "078788c9241ae16763529e1235502337"
SRC_URI[sha256sum] = "e01f70cba5cfbc577b853ae69d73f00db7161e1704dc2359c4377aac4232a184"
