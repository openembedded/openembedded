require python-setuptools_${PV}.bb
inherit native

DEPENDS = "python-native"

do_stage() {
    BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
      ${STAGING_BINDIR_NATIVE}/python setup.py install
}
