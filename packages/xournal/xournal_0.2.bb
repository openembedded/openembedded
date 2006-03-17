LICENSE = "GPL"
HOMEPAGE = "http://www-math.mit.edu/~auroux/software/xournal/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEPENDS = "gtk+ libgnomecanvas libgnomeprintui"

inherit autotools pkgconfig

SRC_URI = "http://www-math.mit.edu/~auroux/software/xournal/${P}.tar.gz"



