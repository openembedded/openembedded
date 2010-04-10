require python-scons_${PV}.bb
inherit native
DEPENDS = "python-native"
RDEPENDS = ""

do_stage() {
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
        ${STAGING_BINDIR}/python setup.py install --prefix=${STAGING_LIBDIR}/.. --install-data=${STAGING_DATADIR} || \
        oefatal "python setup.py install execution failed."
}

do_install() {
	:
}

SRC_URI[md5sum] = "53b6aa7281811717a57598e319441cf7"
SRC_URI[sha256sum] = "2806451e02a42789decb6d08098b798b6b81a0a39d8d3b2fbdd3fe84ebd8a246"
