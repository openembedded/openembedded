DESCRIPTION = "Matchbox window manager common files"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "libmatchbox"
PR = "r5"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://no-utilities-category.patch;patch=1 \
           file://add-media-category.patch;patch=1"

inherit autotools pkgconfig update-alternatives

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "\
  ${bindir} \
  ${datadir}/matchbox/vfolders \
  ${datadir}/pixmaps"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-session"
ALTERNATIVE_PRIORITY = "11"


PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "90acc81aeebc0dca8f88fbaa40166607"
SRC_URI[sha256sum] = "cb56d6a1031c33b98751cb06b2fce73feba49cb38a1e4db1a104e8efdfb9a7dc"
