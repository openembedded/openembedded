require busybox_${PV}.bb

S = "${WORKDIR}/busybox-1.2.1"

export CFLAGS:="${CFLAGS} -static"
