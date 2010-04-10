HOMEPAGE = "http://xournal.sf.net/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
DEPENDS = "gtk+ libgnomecanvas libgnomeprintui"
# For pdftopnm:
RDEPENDS = "poppler"
SECTION = "x11"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://xournal.sourceforge.net/xournal-${PV}.tar.gz \
          "

inherit autotools pkgconfig



SRC_URI[md5sum] = "b3d352d08e71606383c31da5790b8d60"
SRC_URI[sha256sum] = "dff617ca33dc263caecb6afc5d42c109166ef2a1c0fe0afa070ff6691ea0e8d7"
