DESCRIPTION = "o2 theme for the elementary toolkit - it looks like om2007.2"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
DEPENDS = "edje-native"
RSUGGESTS = "phoneui-shr-theme-o2"
LICENSE = "unknown"

SRCREV = "b5eb3134850c277ad8ae1a960b03ff4a509278a8"
PV = "0.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master \
          "

S = "${WORKDIR}/git/elementary/${PN}"

do_compile() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/o2.edc -o ${S}/o2.edj
}

do_install() {
        install -d ${D}${datadir}/elementary/themes/
        install -m 0644 ${S}/o2.edj ${D}${datadir}/elementary/themes/
}

FILES_${PN} = "${datadir}/elementary/themes/"
