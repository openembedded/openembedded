DESCRIPTION = "Extremely blue elementary theme - Niebiee"
SECTION = "e/utils"
DEPENDS = "edje-native"
LICENSE = "MIT BSD"
PV = "0.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/elementary/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/images/. -fd ${S}/fonts/. ${S}/niebiee.edc -o ${S}/niebiee.edj
}

do_install() {
        install -d ${D}${datadir}/elementary/themes/
        install -m 0644 ${S}/niebiee.edj ${D}${datadir}/elementary/themes/
}

FILES_${PN} = "${datadir}/elementary/themes/niebiee.edj"
