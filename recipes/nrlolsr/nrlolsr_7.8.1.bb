DESCRIPTION = "NRL OLSR - added to OE to support the Maniac Challenge (http://www.maniacchallenge.org/)"
SECTION = "applications"
LICENSE = "Public Domain"

S="${WORKDIR}/nrlolsr/"

SRC_URI = "http://downloads.pf.itd.nrl.navy.mil/olsr/nrlolsrdv7.8.1.tgz \
           file://nrlolsr-cross.patch;patch=1 \
          "

do_compile () {
	cd ${S}/unix

	sed -i -e 's:-I/usr/X11R6/include:-I${STAGING_INCDIR}:g' Makefile.linux
	sed -i -e 's:-L/usr/X11R6/lib:-L${STAGING_LIBDIR}:g' Makefile.linux
	sed -i -e 's:/usr/local/bin:${STAGING_BINDIR}:g' Makefile.linux
	sed -i -e 's:make -f Makefile:make -e -f Makefile:g' Makefile.common

#	EXTRA_OEMAKE="-f Makefile.linux"
	oe_runmake -f Makefile.linux

}

do_install () {
	install -d ${D}/${bindir}
	install unix/nrlolsrd ${D}/${bindir}
}

SRC_URI[md5sum] = "46291de38362acdcd335bcf259055046"
SRC_URI[sha256sum] = "0e6b18e3bf77dd20395881535e3e7043bcd5171c220728310215d708f44f3b1c"
