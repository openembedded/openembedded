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




SRC_URI[md5sum] = "456b318fa6e61431bf4f0a42b110014a"
SRC_URI[sha256sum] = "2c2e05f1241e9b76f54475b5577cd4fb6670de058218d04a741a04ebd4a2b22f"
