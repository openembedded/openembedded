DESCRIPTION = "Meta-package for Opie TTF support"
SECTION = "opie/fonts"
DEPENDS = "freetype"
PR = "r4"

SRC_URI = "file://update-qtttffontdir.c"
S = "${WORKDIR}"

do_compile() {
        ${CC} ${CFLAGS} ${LDFLAGS} -I${STAGING_INCDIR}/freetype2 -lfreetype -o update-qtttffontdir update-qtttffontdir.c
}

do_install() {

        echo "
#!/bin/sh
# Author: Rolf Leggewie

${sbindir}/update-qtttffontdir ${datadir}/fonts/truetype > ${palmtopdir}/lib/fonts/fontdir
" > ${WORKDIR}/02qtttffont-update

        install -d ${D}${sbindir}
        install -d ${D}${sysconfdir}/update-fonts-common.d/
        install -m 0755 update-qtttffontdir ${D}${sbindir}
        install -m 0755 02qtttffont-update ${D}${sysconfdir}/update-fonts-common.d/
}

pkg_postinst() {
        if ! [ -d ${palmtopdir}/lib/fonts ]; then
            mkdir -p ${palmtopdir}/lib/fonts
        fi
        ${sysconfdir}/update-fonts-common.d/02qtttffont-update
}
