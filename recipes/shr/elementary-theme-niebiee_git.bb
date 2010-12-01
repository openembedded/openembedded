DESCRIPTION = "Extremely blue elementary theme - Niebiee"
SECTION = "e/utils"
DEPENDS = "edje-native"
LICENSE = "MIT BSD"
SRCREV = "4b89eb1d477fb1e5256e2e35bf214af2c59843eb"
PV = "0.2+gitr${SRCPV}"
PR = "r1"
PACKAGE_ARCH = "all"

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
