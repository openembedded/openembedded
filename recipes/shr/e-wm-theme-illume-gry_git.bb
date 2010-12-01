DESCRIPTION = "gry* illume theme - a fast, shiny illume theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RRECOMMENDS_${PN} = "elementary-theme-gry"
PACKAGE_ARCH = "all"
LICENCE = "unknown"

SRCREV = "bed3a9ac381b88717b153012fa4b9da0c860c6b0"
PV = "0.4+gitr${SRCPV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/gry.edc -o ${S}/gry.edj
}

do_install() {
        install -d ${D}${datadir}/enlightenment/data/themes/
        install -m 0644 ${S}/gry.edj ${D}${datadir}/enlightenment/data/themes/
}

FILES_${PN} = "${datadir}/enlightenment/data/themes/"
