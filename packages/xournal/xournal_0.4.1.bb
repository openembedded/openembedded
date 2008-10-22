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


