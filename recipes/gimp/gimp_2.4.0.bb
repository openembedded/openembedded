require gimp.inc

SRC_URI = "ftp://ftp.gimp.org/pub/gimp/v2.4/gimp-${PV}.tar.bz2 \
                 file://configure-libwmf.patch;patch=1"


SRC_URI[md5sum] = "35fecf14cd5237065aef624b93030d5e"
SRC_URI[sha256sum] = "ddeafb632050bba9163416c4a18c4cb8706b922c0fa99a0c216176584826a9dc"
