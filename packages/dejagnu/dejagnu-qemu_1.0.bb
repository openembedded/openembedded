LICENSE = "GPL"
MAINTAINER = "Phil Blundell <pb@debian.org>"

inherit cross

SRC_URI = "file://arm-qemu.exp"

# fixme
QEMU = "qemu-arm"
LD_SO = "lib/ld-linux.so.2"

do_stage() {
	install -d ${STAGING_DATADIR}/dejagnu/baseboards
	install -m 0644 ${WORKDIR}/arm-qemu.exp ${STAGING_DATADIR}/dejagnu/baseboards/
	cat <<EOF >${STAGING_BINDIR}/${QEMU}-test-wrapper
#!/bin/sh
exec ${QEMU} ${CROSS_DIR}/${TARGET_SYS}/${LD_SO} --library-path ${CROSS_DIR}/${TARGET_SYS}/lib:${STAGING_DIR}/${TARGET_SYS}/lib \$1
EOF
	chmod 755 ${STAGING_BINDIR}/arm-qemu-test-wrapper
}

