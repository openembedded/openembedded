DESCRIPTION = "nEo elementary theme - a very fast, high contrast etk theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RRECOMMENDS = "e-wm-theme-illume-neo gtk-theme-neo libframeworkd-phonegui-efl-theme-neo etk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

PV = "0.2.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r3"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master \
          "

S = "${WORKDIR}/git/elementary/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/neo.edc -o ${S}/neo.edj
}

do_install() {
        install -d ${D}${datadir}/elementary/themes/
        install -m 0644 ${S}/neo.edj ${D}${datadir}/elementary/themes/
}

FILES_${PN} = "${datadir}/elementary/themes/"
