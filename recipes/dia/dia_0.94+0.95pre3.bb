DESCRIPTION = "Dia is a gtk+ based diagram creation program released under the GPL license."
LICENSE = "GPL"
SECTION = "x11/graphics"
DEPENDS = "libart-lgpl libpng cairo zlib gtk+ libxml2"
PR = "r2"

inherit autotools pkgconfig

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/dia/0.95/dia-0.95-pre3.tar.gz"

S = "${WORKDIR}/${PN}-0.95-pre3"

#work around some pkgconfig breakages
LDFLAGS += "-lart_lgpl_2 -lxml2 -lgthread-2.0 -lglib-2.0"
CFLAGS += "-I${STAGING_INCDIR}/libart-2.0 "

FILES_${PN} += "${datadir}/mime-info/"



SRC_URI[md5sum] = "642f7e7d4c71dc144b60f51f9d65de62"
SRC_URI[sha256sum] = "902da1b1e9d90dfda8aa1864846db8ad12386e7521fc9f8b18c8ba220dd0123a"
