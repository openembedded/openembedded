DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"

PACKAGE_ARCH="all"
PV = "0.0+svnr${SRCREV}"
PR = "r5"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=illume;proto=https"
S = "${WORKDIR}/illume"

CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes/
    install -d ${D}${datadir}/enlightenment/data/init/

    # Make illume the default profile
    echo 'E_PROFILE="-profile illume"' > ${D}${sysconfdir}/enlightenment/default_profile

    install -m 0644 ${S}/misc-data/illume.edj ${D}${datadir}/enlightenment/data/themes/
    install -m 0644 ${S}/misc-data/illume_init.edj ${D}${datadir}/enlightenment/data/init/
}
