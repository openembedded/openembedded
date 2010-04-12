require python-divmodepsilon_${PV}.bb
inherit native

DEPENDS = "python-native python-twisted-native zope-native"

do_stage() {
    BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
    STAGING_LIBDIR=${STAGING_LIBDIR} STAGING_INCDIR=${STAGING_INCDIR} \
        ${STAGING_BINDIR}/python setup.py install --prefix=${STAGING_BINDIR}/.. --install-data=${STAGING_DATADIR}
}


SRC_URI[md5sum] = "39710dfdeb42e51c953b17b6cded163e"
SRC_URI[sha256sum] = "a5907a3b7584d63be30b3f79b0422b2b0778e73c053be9ac5a11004f1c9097dc"
