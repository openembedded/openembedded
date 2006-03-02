DESCRIPTION = "Dia is a gtk+ based diagram creation program released under the GPL license."
LICENSE = "GPL"
DEPENDS = "libpng cairo zlib gtk+ libxml2"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"


inherit autotools pkgconfig

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/dia/0.95/dia-0.95-pre3.tar.gz"

S = "${WORKDIR}/${PN}-0.95-pre3"
LDFLAGS += "-lxml2 -lgthread-2.0 -lglib-2.0"


