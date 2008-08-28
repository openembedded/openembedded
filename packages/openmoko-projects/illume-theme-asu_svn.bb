DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"
RPROVIDES_${PN} = "illume-theme"
RCONFLICTS = "illume-config"
PV = "0.0+svnr${SRCREV}"
PR = "r7"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=illume;proto=http"

S = "${WORKDIR}/illume"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes
    install -d ${D}${datadir}/enlightenment/data/init
    # Make asu the default profile
    echo 'E_PROFILE="-profile asu"' > ${D}${sysconfdir}/enlightenment/default_profile
    install -m 0644 ${S}/misc-data/illume.edj ${D}${datadir}/enlightenment/data/themes/illume.edj
    install -m 0644 ${S}/misc-data/illume_init.edj ${D}${datadir}/enlightenment/data/init/illume_init.edj
}

PACKAGE_ARCH_${PN} = "all"

FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
