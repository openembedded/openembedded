require busybox_${PV}.bb

FILESPATHPKG =. "${P}:${BPN}:busybox-${PV}:"
S = "${WORKDIR}/busybox-${PV}"
