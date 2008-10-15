require edje_svn.bb

inherit sdk
FILE_PR = "r0"

SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-sdk', '')}"
DEPENDS = "evas-native ecore-native eet-native embryo-native"
S = "${WORKDIR}/edje"

