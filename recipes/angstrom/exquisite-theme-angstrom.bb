DDESCRIPTION = "Angstrom theme for exquisite"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "MIT/BSD"
SECTION = "x11"

DEPENDS = "edje-native"
RRECOMMENDS_${PN} = "exquisite"

SRCREV = "${EFL_SRCREV}"
PV = "1.0+svnr${SRCREV}"
PR = "r2"

inherit update-alternatives

ALTERNATIVE_NAME = "exquisite-config"
ALTERNATIVE_LINK = "${sysconfdir}/exquisite/config"
ALTERNATIVE_PATH = "${sysconfdir}/exquisite/config-angstrom"
ALTERNATIVE_PRIORITY = "20"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=THEMES/b_and_w;proto=http \
           file://exq-logo.png \
           file://exq-logoglow.png \
"

S = "${WORKDIR}/THEMES/b_and_w"

do_compile() {
   cp ${WORKDIR}/*png ${S}/
   edje_cc exquisite.edc angstrom.edj
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
