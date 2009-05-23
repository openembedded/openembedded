RPROVIDES += "virtual/shr-splash-theme"
RDEPENDS += "shr-splash"

inherit update-alternatives

FILES_${PN} = "${datadir}/shr-splash/themes/${PN}"

ALTERNATIVE_NAME = "shr-splash-theme"
ALTERNATIVE_LINK = "${datadir}/shr-splash/theme"
ALTERNATIVE_PATH = "${datadir}/shr-splash/themes/${PN}"

do_install() {
    install -d ${D}${datadir}/shr-splash/themes/${PN}

    install -m 0755 ${S}/xsplash-vga.ppm ${D}${datadir}/shr-splash/themes/${PM}/xsplash-vga.ppm
    install -m 0755 ${S}/boot.fb ${D}${datadir}/shr-splash/themes/${PN}/boot.fb
    install -m 0755 ${S}/shutdown.fb ${D}${datadir}/shr-splash/themes/${PN}/shutdown.fb
}
