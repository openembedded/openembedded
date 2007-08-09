require busybox_${PV}.bb
PR = "r0"

S = "${WORKDIR}/busybox-1.2.1"

export CFLAGS:="${CFLAGS} -static"
