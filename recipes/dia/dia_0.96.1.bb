DESCRIPTION = "Dia is a gtk+ based diagram creation program released under the GPL license."
LICENSE = "GPL"
SECTION = "x11/graphics"
DEPENDS = "libart-lgpl libpng cairo zlib gtk+ libxml2"

inherit gnome  pkgconfig

#work around some pkgconfig breakages
LDFLAGS += "-lart_lgpl_2 -lxml2 -lgthread-2.0 -lglib-2.0"
CFLAGS += "-I${STAGING_INCDIR}/libart-2.0 "

FILES_${PN} += "${datadir}/mime-info/"



SRC_URI[archive.md5sum] = "7b81b22baa2df55efe4845865dddc7b6"
SRC_URI[archive.sha256sum] = "7bb43d8b0cb287d728ea479fb65d1b57b8530af773018214e7f312dceed34237"
