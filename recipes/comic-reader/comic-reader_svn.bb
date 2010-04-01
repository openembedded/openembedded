DESCRIPTION = "A comic reader for Otaku"
HOMEPAGE = "http://code.google.com/p/comic-reader/"
LICENSE = "GPLv3"
DEPENDS = "evas edje ecore etk eet edbus"
PR = "r3"
SRCREV = "56"

SRC_URI = "svn://comic-reader.googlecode.com/svn/;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

EXTRA_OECONF = ""

FILES_${PN} += "${prefix}/share/*"

PKG_TAGS_${PN} = "group::games"
