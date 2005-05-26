LICENSE = 	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = "gtk+ outo xtst libmatchbox libxi xt libpng gconf"

SRC_URI = 	"http://repository.maemo.org/pool/maemo/ossw/source/h/hildon-lgpl/hildon-lgpl_${PV}.tar.gz \
			file://hildon-lgpl-noWerror.patch;patch=1"

S =	"${WORKDIR}/hildon-lgpl-0.9.14"
EXTRA_OECONF =	"--disable-gtk-doc"

inherit pkgconfig autotools
