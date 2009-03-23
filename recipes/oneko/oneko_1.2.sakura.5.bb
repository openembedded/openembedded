DESCRIPTION = "Small cat chasing mouse cursor"
AUTHOR = "Tatsuya Kato"
HOMEPAGE = "http://www.daidouji.com/oneko/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "PD"
DEPENDS = "virtual/libx11 libxext"

SRC_URI = "http://www.daidouji.com/oneko/distfiles/oneko-${PV}.tar.gz \
           file://oneko.desktop \
           file://kill-oneko.desktop \
	   file://oneko.png \
	   file://kill-oneko.png \
	   file://remove-bsd-daemon-logo.patch;patch=1"

inherit pkgconfig 

do_compile() {
	${CC} oneko.c -o oneko -lm `pkg-config  --cflags --libs x11 xext` \
	-DSHAPE
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/applications
	install -d ${D}/${datadir}/pixmaps
	install -d ${D}/${mandir}/man6
	install -m 0755 ${S}/oneko ${D}/${bindir}
	install -m 0644 ${WORKDIR}/*oneko.png ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/*oneko.desktop ${D}/${datadir}/applications
	install -m 0644 ${S}/oneko.man ${D}/${mandir}/man6/oneko.6
}



