DESCRIPTION = "elementary SHR theme"
SECTION = "e/utils"
DEPENDS = "edje-native"
LICENSE = "MIT BSD"
PV = "0.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/elementary/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/images/. -fd ${S}/fonts/. ${S}/sixteen.edc -o ${S}/sixteen.edj
}

do_install() {
        install -d ${D}${datadir}/elementary/themes/
        install -m 0644 ${S}/sixteen.edj ${D}${datadir}/elementary/themes/
}

FILES_${PN} = "${datadir}/elementary/themes/sixteen.edj"


