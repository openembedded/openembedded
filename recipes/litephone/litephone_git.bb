require litephone.inc

SRCREV = "4c9f16d9acc6cd18fc3f647b7e4f44a2d3bdd7b6"
PV = "0.1+gitr${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://git.senfdax.de/git/litephone;protocol=http \
           file://files/litephone.desktop"

S = "${WORKDIR}/git/"

do_install() {
    install -d ${D}/${datadir}/pixmaps
    install -m 644 ${S}/pics/blue/Mobile.png ${D}/${datadir}/pixmaps/litephone-mobile.png
    install -d ${D}/${bindir}
    install -m 0755 ${S}/litephone ${D}/${bindir}
    install -d ${D}/etc/litephone
    install ${S}/style_sheet.conf ${D}/etc/litephone/
    install -d ${D}/${datadir}/litephone/translations
    install ${S}/translations/*.qm ${D}/${datadir}/litephone/translations/
    install -d ${D}/${datadir}/applications
    install ${WORKDIR}/files/litephone.desktop ${D}/${datadir}/applications/
}

FILES_${PN}-locale-pl-pl += "/usr/share/litephone/translations/litephone_pl.qm"
PACKAGES =+ "${PN}-locale-pl-pl"
