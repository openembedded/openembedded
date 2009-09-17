DESCRIPTION = "etk SHR theme"
SECTION = "e/utils"
DEPENDS = "edje-native"
LICENSE = "MIT BSD"
PV = "1.1-${EFL_SRCREV}-gitr${SRCREV}"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/etk/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/default.edc -o ${S}/default.edj
}

do_install() {
        install -d ${D}${datadir}/etk/themes/
        install -m 0644 ${S}/default.edj ${D}${datadir}/etk/themes/
}

FILES_${PN} = "${datadir}/etk/themes/default.edj"


