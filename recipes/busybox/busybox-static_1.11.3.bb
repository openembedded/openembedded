require busybox_${PV}.bb
PR = "${INC_PR}.1"

FILESPATH = "${FILE_DIRNAME}/busybox-${PV}:${FILE_DIRNAME}/files:${FILE_DIRNAME}"
S = "${WORKDIR}/busybox-${PV}"

do_configure_append() {
	sed -i -e '/CONFIG_STATIC/d' .config
	echo "CONFIG_STATIC=y" >>.config
}

