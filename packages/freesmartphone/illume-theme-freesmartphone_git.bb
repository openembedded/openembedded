DESCRIPTION = "Illume theme for the freesmartphone.org project"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"
PV = "0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master"
S = "${WORKDIR}/git/illume"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes/
    install -d ${D}${datadir}/enlightenment/data/init/

    # Make illume the default profile
    echo 'E_PROFILE="-profile illume"' > ${D}${sysconfdir}/enlightenment/default_profile

    install -m 0644 ${S}/illume.edj ${D}${datadir}/enlightenment/data/themes/
    install -m 0644 ${S}/illume_init.edj ${D}${datadir}/enlightenment/data/init/
}

RPROVIDES_${PN} = "illume-theme"
CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

PACKAGE_ARCH_${PN} = "all"

