SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager common files"
LICENSE = "GPL"
DEPENDS = "libmatchbox"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-common/${PV}/matchbox-common-${PV}.tar.bz2"
S = "${WORKDIR}/matchbox-common-${PV}"

inherit autotools  pkgconfig

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox/vfolders \
	       ${datadir}/pixmaps"

SRC_URI[md5sum] = "107ac7cfb5f5ad3eacd14388a34a706b"
SRC_URI[sha256sum] = "39672384843942210eca6e16396768b979e479a8e1a8d42d092ad517f561c20d"
