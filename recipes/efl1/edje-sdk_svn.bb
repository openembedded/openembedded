require edje_svn.bb

inherit sdk
PR = "r1"

SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-sdk', '')}"
DEPENDS = "evas-native ecore-native eet-native embryo-native"
S = "${WORKDIR}/edje"

HOST_STAGING_NAME = "${@bb.data.getVar('STAGING_DIR_HOST', d, 1).replace('-sdk', '')}"

CPPFLAGS += "-isystem${HOST_STAGING_NAME}/usr/include/eina-0 -isystem${HOST_STAGING_NAME}/usr/include/eina-0/eina"
