DESCRIPTION = "Meta-package for Opie TTF support"
DEPENDS = "freetype opie-freetype"
RDEPENDS = "opie-freetype"
SECTION = "opie/fonts"
PR = "r2"

SRC_URI = "file://update-qtttffontdir.c"
S = "${WORKDIR}"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -I${STAGING_INCDIR}/freetype2 -lfreetype -o update-qtttffontdir update-qtttffontdir.c 
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 update-qtttffontdir ${D}${sbindir}
}

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]
then
	${sbindir}/update-qtttffontdir /usr/local/share/fonts/truetype >/opt/QtPalmtop/lib/fonts/fontdir
	exit 0
else
	exit 1
fi
}
