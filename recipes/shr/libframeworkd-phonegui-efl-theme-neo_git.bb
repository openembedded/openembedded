DESCRIPTION = "nEo libframeworkd-phonegui-efl - a very fast, high contrast etk theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RDEPENDS = "libframeworkd-phonegui-efl"
RRECOMMENDS = "elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo etk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r2"

require libframeworkd-phonegui-efl-theme.inc

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/libframeworkd-phonegui-efl/theme-neo"

do_compile() {
        for edc in call contacts dialer dialog elm-resizing-label incoming-message keypad messages sim-auth ussd ; do
                ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/${edc}/. -fd ${S}/${edc}. ${S}/${edc}/${edc}.edc -o ${S}/${edc}.edj
        done
}

do_install() {
        install -d ${D}${datadir}/libframeworkd-phonegui-efl.${PN}/
        install -m 0644 ${S}/*.edj ${D}${datadir}/libframeworkd-phonegui-efl.${PN}/
}
