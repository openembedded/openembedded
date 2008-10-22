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
