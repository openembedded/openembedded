DESCRIPTION = "Extremely blue libphone-ui-shr theme - Niebiee"
AUTHOR = "Sebastian Krzyszkowiak <dos@dosowisko.net>"
SECTION = "e/utils"
LICENSE = "unknown"
DEPENDS = "edje-native"
RDEPENDS_${PN} = "libphone-ui-shr"
RSUGGESTS_${PN} = "elementary-theme-niebiee"
SRCREV = "8bf704525807f8a29fa1f3ad653d3fea81cd5aa3"
PV = "0.1+gitr${SRCPV}"
PR = "r1"
PACKAGE_ARCH = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/phoneui-shr/${PN}"

do_compile() {
        ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/niebiee.edc -o ${S}/niebiee.edj
}
do_install() {
        install -d ${D}${datadir}/libphone-ui-shr/
        install -m 0644 ${S}/niebiee.edj ${D}${datadir}/libphone-ui-shr/
        install -m 0644 ${S}/number-icon.png ${D}${datadir}/libphone-ui-shr/
        install -m 0644 ${S}/config ${D}${datadir}/libphone-ui-shr/
}

FILES_${PN} = "${datadir}/libphone-ui-shr/"
CONFFILES_${PN} = "${datadir}/libphone-ui-shr/config"
