LICENSE = "GPL"

inherit cross

SRC_URI = "file://arm-qemu.exp"

# fixme
QEMU = "qemu-arm"
LD_SO = "lib/ld-linux.so.2"

do_stage() {
	install -d ${STAGING_DATADIR}/dejagnu/baseboards
	install -m 0644 ${WORKDIR}/arm-qemu.exp ${STAGING_DATADIR}/dejagnu/baseboards/
	cat <<EOF >${STAGING_BINDIR_NATIVE}/${QEMU}-test-wrapper
#!/bin/sh
exec ${QEMU} ${TOOLCHAIN_PATH}/${TARGET_SYS}/${LD_SO} --library-path ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib:${STAGING_DIR_TARGET}${layout_libdir} \$1
EOF
	chmod 755 ${STAGING_BINDIR_NATIVE}/arm-qemu-test-wrapper
}

