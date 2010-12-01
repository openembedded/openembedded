RDEPENDS_${PN} += "shr-splash"

inherit update-alternatives

FILES_${PN} = "${datadir}/shr-splash/themes/${PN}"

INC_PR = "r7"

# only shr-splash-theme-logo recipe is MACHINE specific
PACKAGE_ARCH = "all"

ALTERNATIVE_NAME = "shr-splash-theme"
ALTERNATIVE_LINK = "${datadir}/shr-splash/theme"
ALTERNATIVE_PATH = "${datadir}/shr-splash/themes/${PN}"
ALTERNATIVE_PRIORITY ?= 1

SS ?= "${S}"

do_install() {
    install -d ${D}${datadir}/shr-splash/themes/${PN}

    install -m 0644 ${SS}/xsplash-vga.ppm ${D}${datadir}/shr-splash/themes/${PN}/xsplash-vga.ppm
    install -m 0644 ${SS}/boot.fbz ${D}${datadir}/shr-splash/themes/${PN}/boot.fbz
    install -m 0644 ${SS}/shutdown.fbz ${D}${datadir}/shr-splash/themes/${PN}/shutdown.fbz
    install -m 0644 ${S}/name ${D}${datadir}/shr-splash/themes/${PN}/name
    install -m 0644 ${S}/author ${D}${datadir}/shr-splash/themes/${PN}/author
    install -m 0644 ${SS}/preview.png ${D}${datadir}/shr-splash/themes/${PN}/preview.png
}

