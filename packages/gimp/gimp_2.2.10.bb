DESCRIPTION =	"The GIMP is the GNU Image Manipulation Program."
HOMEPAGE = 	"http://www.gimp.org"
LICENSE =	"GPL"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"

SRC_URI =	"ftp://ftp.gimp.org/pub/gimp/v2.2/gimp-${PV}.tar.bz2"

DEPENDS =	"gtk+ jpeg libpng libexif"

inherit autotools pkgconfig
#Don't laugh, this just builds a threaded gimp
EXTRA_OECONF = 	" --disable-gtktest \
		--without-libtiff \
		--disable-print \
		--enable-mp" 

do_configure_append() {
    find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
}
	
