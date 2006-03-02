DESCRIPTION = "Dia is a gtk+ based diagram creation program released under the GPL license."
LICENSE = "GPL"
DEPENDS = "libart-lgpl libpng cairo zlib gtk+ libxml2"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
PR = "r1"

inherit autotools pkgconfig

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/dia/0.95/dia-0.95-pre3.tar.gz"

S = "${WORKDIR}/${PN}-0.95-pre3"

#work around some pkgconfig breakages
LDFLAGS += "-lart_lgpl_2 -lxml2 -lgthread-2.0 -lglib-2.0"
CFLAGS += "-I${STAGING_INCDIR}/libart-2.0 "

FILES_${PN} += "${datadir}/mime-info/"


