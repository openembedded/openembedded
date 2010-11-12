DESCRIPTION = "Lightweight text editor for programmers."
HOMEPAGE = "http://triptico.com/software/mp.html"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+"
SRC_URI = "http://triptico.com/download/mp-${PV}.tar.gz \
	file://mped.desktop \
	file://mped.png "

S = "${WORKDIR}/mp-${PV}"
PR = "r0"

inherit base

do_configure() {
	./config.sh --without-curses --prefix=/usr
}
do_install() {
	mkdir -p ${D}/usr/bin
	oe_runmake install DESTDIR=${D}
	mkdir -p ${D}/usr/share/applications ${D}/usr/share/pixmaps
	install -m644 ../mped.desktop ${D}/usr/share/applications
	install -m644 ../mped.png ${D}/usr/share/pixmaps
}

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "/usr/share/mp*/mp_*"
#FIXME: /usr/share/mp-5/lang

# FIXME: should verify those checksums through other means
SRC_URI[md5sum] = "6ed30d6be7da70e13111dbc7fca00e70"
SRC_URI[sha256sum] = "b9c2773408638eeddfa0eef912cc289b0b92df34ce621dc46eca47a2dc518986"
