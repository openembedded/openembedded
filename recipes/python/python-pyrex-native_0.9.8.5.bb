require python-pyrex_${PV}.bb
inherit native
DEPENDS = "python-native"
RDEPENDS = ""

do_stage() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
	STAGING_LIBDIR=${STAGING_LIBDIR} STAGING_INCDIR=${STAGING_INCDIR} \
        ${STAGING_BINDIR}/python setup.py install --prefix=${STAGING_BINDIR}/.. --install-data=${STAGING_DATADIR}
}

SRC_URI[md5sum] = "3b3d8397c2c9a58fc59a90e2b49c651a"
SRC_URI[sha256sum] = "dd60bc66b1627d3cbd0950499017dfd57a0705bb12493bb0de2a7b9b5c0873bc"
