DESCRIPTION = "Meta-package for Opie TTF support"
DEPENDS = "freetype"
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
if [ -n "$D" ]; then exit 1; fi
mkdir -p ${palmtopdir}/lib/fonts/
${sbindir}/update-qtttffontdir ${datadir}/fonts/truetype >${palmtopdir}/lib/fonts/fontdir
}
