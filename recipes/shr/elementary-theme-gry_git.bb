DESCRIPTION = "gry* elementary theme - a fast, shiny elementary theme"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
LICENSE = "unknown"

PV = "0.1-${EFL_SRCREV}-gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master \
          "

S = "${WORKDIR}/git/elementary/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/gry.edc -o ${S}/gry.edj
}

do_install() {
        install -d ${D}${datadir}/elementary/themes/
        install -m 0644 ${S}/gry.edj ${D}${datadir}/elementary/themes/
}

FILES_${PN} = "${datadir}/elementary/themes/"
