DDESCRIPTION = "Angstrom theme for exquisite"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "MIT/BSD"
SECTION = "x11"

DEPENDS = "edje-native"
RRECOMMENDS_${PN} = "exquisite"

PV = "1.2"

inherit update-alternatives

ALTERNATIVE_NAME = "exquisite-config"
ALTERNATIVE_LINK = "${sysconfdir}/exquisite/config"
ALTERNATIVE_PATH = "${sysconfdir}/exquisite/config-angstrom"
ALTERNATIVE_PRIORITY = "20"

SRC_URI = "file://angstrom/"

S = "${WORKDIR}/angstrom"

do_compile() {
   edje_cc exquisite-ang.edc angstrom.edj
}

do_install() {
    install -d ${D}${sysconfdir}/exquisite
    install -d ${D}${datadir}/exquisite/data/themes
    install -m 0644 ${S}/angstrom.edj ${D}${datadir}/exquisite/data/themes/
    echo 'THEME="-t angstrom"' > ${D}${sysconfdir}/exquisite/config-angstrom
}

PACKAGE_ARCH = "all"
CONFFILES_${PN} = "${sysconfdir}/exquisite/config-angstrom"
FILES_${PN} = "${sysconfdir}/exquisite ${datadir}/exquisite/data/themes"
