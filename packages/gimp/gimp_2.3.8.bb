DESCRIPTION =	"The GIMP is the GNU Image Manipulation Program."
HOMEPAGE = 	"http://www.gimp.org"
LICENSE =	"GPL"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"

SRC_URI =	"ftp://ftp.gimp.org/pub/gimp/v2.3/gimp-${PV}.tar.bz2 \
                 file://configure-libwmf.patch;patch=1"

DEPENDS =	"sed-native libart-lgpl gtk+ jpeg libpng libexif tiff"

inherit autotools pkgconfig
#Don't laugh, this just builds a threaded gimp
EXTRA_OECONF = 	" --disable-gtktest \
		--disable-print \
		--disable-python \
		--enable-mp \
		--without-libwmf"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
}
