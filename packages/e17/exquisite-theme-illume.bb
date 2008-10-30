DDESCRIPTION = "A theme for exquisite"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "MIT/BSD"
PACKAGE_ARCH="all"
PV = "1.0"
PR = "r5"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=THEMES/b_and_w;proto=http"
S = "${WORKDIR}/THEMES/b_and_w"

do_compile() {
   edje_cc exquisite.edc illume.edj
}

CONFFILES_${PN} = "${sysconfdir}/exquisite/config-illume"
FILES_${PN} = "${sysconfdir}/exquisite ${datadir}/exquisite/data/themes"

do_install() {
    install -d ${D}${sysconfdir}/exquisite
    install -d ${D}${datadir}/exquisite/data/themes
    install -m 0644 ${S}/illume.edj ${D}${datadir}/exquisite/data/themes/
    echo 'THEME="-t illume"' > ${D}${sysconfdir}/exquisite/config-illume
}

inherit update-alternatives

ALTERNATIVE_NAME = "exquisite-config"
ALTERNATIVE_LINK = "${sysconfdir}/exquisite/config"
ALTERNATIVE_PATH = "${sysconfdir}/exquisite/config-illume"
ALTERNATIVE_PRIORITY = "10"
