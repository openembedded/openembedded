DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native"
RPROVIDES_${PN} = "illume-theme"
RCONFLICTS = "illume-config"
PV = "0.0+svnr${SRCPV}"
PR = "r9"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target/themes/;module=illume-theme-asu;proto=http"

S = "${WORKDIR}/illume-theme-asu"

do_compile() {
    cd misc-data/asu && ./build.sh && cd ../..
    cd misc-data/asu_init && ./build.sh && cd ../..
    cd config
    eet -e e.cfg config e.src 1
    eet -e module.battery.cfg config module.battery.src 1
    eet -e module.illume.cfg config module.illume.src 1
}

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes
    install -d ${D}${datadir}/enlightenment/data/init
    install -d ${D}${datadir}/enlightenment/data/config/asu
    # Make asu the default profile
    echo 'E_PROFILE="-profile asu"' > ${D}${sysconfdir}/enlightenment/default_profile
    install -m 0644 ${S}/misc-data/asu/asu.edj ${D}${datadir}/enlightenment/data/themes/asu.edj
    install -m 0644 ${S}/misc-data/asu_init/asu_init.edj ${D}${datadir}/enlightenment/data/init/asu_init.edj
    install -m 0644 ${S}/config/*.cfg ${D}${datadir}/enlightenment/data/config/asu
}

PACKAGE_ARCH_${PN} = "all"
PACKAGES = "\
    ${PN} \
"
FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
