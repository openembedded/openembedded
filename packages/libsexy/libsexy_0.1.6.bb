DESCRIPTION = "Libsexy is a collection of GTK+ widgets that extend the functionality of such standard widgets as GtkEntry and GtkLabel"
HOMEPAGE = "http://wiki.chipx86.com/wiki/Libsexy"
AUTHOR = "Christian Hammond <chipx86@chipx86.com>"
MAINTAINER = "Koen Kooi <koen@handhelds.org>""
PR = "r0"

DEPENDS = "gtk+ enchant libxml2"

SRC_URI = "http://osiris.chipx86.com/projects/libsexy/releases/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}


