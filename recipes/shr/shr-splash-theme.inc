RPROVIDES_${PN} = "virtual/shr-splash-theme"
PROVIDES  = "virtual/shr-splash-theme"
RDEPENDS += "shr-splash"

inherit update-alternatives

FILES_${PN} = "${datadir}/shr-splash/themes/${PN}"

ALTERNATIVE_NAME = "shr-splash-theme"
ALTERNATIVE_LINK = "${datadir}/shr-splash/theme"
ALTERNATIVE_PATH = "${datadir}/shr-splash/themes/${PN}"
ALTERNATIVE_PRIORITY ?= 1

do_install() {
    install -d ${D}${datadir}/shr-splash/themes/${PN}

    install -m 0644 ${S}/xsplash-vga.ppm ${D}${datadir}/shr-splash/themes/${PN}/xsplash-vga.ppm
    install -m 0644 ${S}/boot.fbz ${D}${datadir}/shr-splash/themes/${PN}/boot.fbz
    install -m 0644 ${S}/shutdown.fbz ${D}${datadir}/shr-splash/themes/${PN}/shutdown.fbz
    install -m 0644 ${S}/name ${D}${datadir}/shr-splash/themes/${PN}/name
    install -m 0644 ${S}/author ${D}${datadir}/shr-splash/themes/${PN}/author
    install -m 0644 ${S}/preview.png ${D}${datadir}/shr-splash/themes/${PN}/preview.png
}

