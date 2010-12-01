DESCRIPTION = "o2 theme for libphone-ui-shr - it looks like om2007.2"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
SECTION = "e/utils"
LICENSE = "unknown"
DEPENDS = "edje-native"
RDEPENDS_${PN} = "libphone-ui-shr"
RSUGGESTS_${PN} = "elementary-theme-o2"
SRCREV = "20e5e82819a7612aa31c753a6898ccc9e940c7c6"
PV = "0.1+gitr${SRCPV}"
PR = "r2"
PACKAGE_ARCH = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/phoneui-shr/${PN}"

do_compile() {
        ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/o2.edc -o ${S}/o2.edj
}
do_install() {
        install -d ${D}${datadir}/libphone-ui-shr/
        install -m 0644 ${S}/o2.edj ${D}${datadir}/libphone-ui-shr/
        install -m 0644 ${S}/config ${D}${datadir}/libphone-ui-shr/
}

FILES_${PN} = "${datadir}/libphone-ui-shr/"
CONFFILES_${PN} = "${datadir}/libphone-ui-shr/config"
