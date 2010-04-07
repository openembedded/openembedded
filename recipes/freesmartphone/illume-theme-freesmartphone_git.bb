DESCRIPTION = "Illume theme for the freesmartphone.org project"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native"
SRCREV = "b1b0f6adc59e6f72a3929771058e3750bf181bc5"
PV = "0.1.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master"
S = "${WORKDIR}/git/illume"

do_compile() {
   cd illume && ./build.sh && cd ..
   cd illume_init && ./build.sh && cd ..
   cd illume-config
   eet -e e.cfg config e.src 1
   eet -e module.battery.cfg config module.battery.src 1
   eet -e module.illume.cfg config module.illume.src 1
}

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -d ${D}${datadir}/enlightenment/data/themes/
    install -d ${D}${datadir}/enlightenment/data/init/
    install -d ${D}${datadir}/enlightenment/data/config/fso/

    # Make fso the default profile
    echo 'E_PROFILE="-profile fso"' > ${D}${sysconfdir}/enlightenment/default_profile

    install -m 0644 ${S}/illume/fso.edj ${D}${datadir}/enlightenment/data/themes/
    install -m 0644 ${S}/illume_init/fso_init.edj ${D}${datadir}/enlightenment/data/init/
    
    install -m 0644 ${S}/illume-config/e.cfg ${D}${datadir}/enlightenment/data/config/fso/
    install -m 0644 ${S}/illume-config/module.battery.cfg ${D}${datadir}/enlightenment/data/config/fso/
    install -m 0644 ${S}/illume-config/module.illume.cfg ${D}${datadir}/enlightenment/data/config/fso/
}

RPROVIDES_${PN} = "illume-theme"
CONFFILES_${PN} = "${sysconfdir}/enlightenment/default_profile"
FILES_${PN} = "${sysconfdir}/enlightenment ${datadir}/enlightenment"

PACKAGE_ARCH_${PN} = "all"

