require fakeroot_${PV}.bb

RDEPENDS_${PN} = "util-linux-native"

SRC_URI += "file://fix-prefix.patch "
S = "${WORKDIR}/fakeroot-${PV}"

inherit native

EXTRA_OECONF = " --program-prefix="

# Compatability for the rare systems not using or having SYSV
python () {
    if bb.data.getVar('HOST_NONSYSV', d, True) and bb.data.getVar('HOST_NONSYSV', d, True) != '0':
        bb.data.setVar('EXTRA_OECONF', ' --with-ipc=tcp --program-prefix= ', d)
}

do_stage_append () {
    oe_libinstall -so libfakeroot ${STAGING_LIBDIR}/libfakeroot/
}

SRC_URI[md5sum] = "659a1f3a36554abfc2a3eaad2fdc0604"
SRC_URI[sha256sum] = "b035c834944bf9482027f48c388de8492e96609825265ac03f05408d0b3aae68"
