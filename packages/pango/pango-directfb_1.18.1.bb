require pango.inc
RCONFLICTS = "pango"
DEPENDS = "glib-2.0 fontconfig freetype zlib virtual/libiconv gtk-doc cairo-directfb"
SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/pango/1.18/pango-${PV}.tar.bz2 \
	   file://no-tests.patch;patch=1"

S = "${WORKDIR}/pango-${PV}"
RRECOMMENDS_${PN} = "" 
FILESPATH = "${FILE_DIRNAME}/pango-${PV}:${FILE_DIRNAME}/files"
