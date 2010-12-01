DESCRIPTION = "nEo illume theme - a very fast, high contrast illume theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RDEPENDS_${PN} = "e-wm"
RSUGGESTS_${PN} = "elementary-theme-neo gtk-theme-neo gpe-theme-neo icon-theme-neo"
PACKAGE_ARCH = "all"
LICENCE = "unknown"

SRCREV = "c2443c4052997045f8862462a06a5b07dce42cb5"
PV = "0.2+gitr${SRCPV}"
PR = "r4"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/neo.edc -o ${S}/neo.edj
}

do_install() {
        install -d ${D}${datadir}/enlightenment/data/themes/
        install -m 0644 ${S}/neo.edj ${D}${datadir}/enlightenment/data/themes/
}

FILES_${PN} = "${datadir}/enlightenment/data/themes/"

pkg_postinst() {
        echo "To activate this theme make sure to set your enlightenment rendering engine to SOFTWARE or enlightenment will segfault."
        echo "This theme also ships with an enlightenment bootscreen which can be activated by selecting it under STARTUP in the LOOK tab of enlightenment settings"
        echo "After activating this theme be sure to switch to SOFTWARE_16 engine in enlightenment advanced settings to unleash the theme's full power ;-)"
}
