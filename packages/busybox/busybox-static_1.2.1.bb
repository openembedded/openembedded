require busybox_${PV}.bb
PR = "r2"

S = "${WORKDIR}/busybox-1.2.1"

export CFLAGS:="${CFLAGS} -static"
