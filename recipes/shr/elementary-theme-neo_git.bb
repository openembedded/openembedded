DESCRIPTION = "nEo elementary theme - a very fast, high contrast elementary theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RSUGGESTS = "elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo etk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

SRCREV = "fb377425e69ce1fc13f5094801b96836203e8154"
PV = "0.5-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r0"

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
