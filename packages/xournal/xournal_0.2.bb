HOMEPAGE = "http://xournal.sf.net/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEPENDS = "gtk+ libgnomecanvas"
SECTION = "x11"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://xournal.sourceforge.net/xournal-0.2.tar.gz \
        file://no-printing.diff;patch=1"

inherit autotools pkgconfig
