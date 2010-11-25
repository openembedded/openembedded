require busybox_${PV}.bb
PR = "${INC_PR}.0"

FILESPATHPKG =. "busybox-${PV}:"
S = "${WORKDIR}/busybox-${PV}"

do_configure_append() {
	sed -i -e '/CONFIG_STATIC/d' .config
	echo "CONFIG_STATIC=y" >>.config
}

