require busybox_${PV}.bb
PR = "r4"

FILESPATH = "${FILE_DIRNAME}/busybox-${PV}:${FILE_DIRNAME}/files:${FILE_DIRNAME}"
S = "${WORKDIR}/busybox-${PV}"

do_configure_append() {
	sed -i -e '/CONFIG_STATIC/d' .config
	echo "CONFIG_STATIC=y" >>.config
}

