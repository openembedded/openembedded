DESCRIPTION = "Illume theme for Illume E module"
HOMEPAGE = "http://www.enlightenment.org/"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native"
PV = "0.0+${PR}-svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=THEMES/b_and_w;proto=http"
S = "${WORKDIR}/THEMES/b_and_w"

do_compile() {
   edje_cc illume.edc
   edje_cc illume_init.edc
}

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes/
    install -d ${D}${datadir}/enlightenment/data/init/

    # FIXME: hack. should modify profile.cfg and nto use enlightenment_start.oe
    echo 'E_PROFILE="-profile illume"' > ${D}${sysconfdir}/enlightenment/default_profile

    install -m 0644 ${S}/illume.edj ${D}${datadir}/enlightenment/data/themes/
    install -m 0644 ${S}/illume_init.edj ${D}${datadir}/enlightenment/data/init/
}

RPROVIDES_${PN} = "illume-theme"
CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

PACKAGE_ARCH_${PN} = "all"

