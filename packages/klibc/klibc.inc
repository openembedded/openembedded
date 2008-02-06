require klibc-common.inc

STAGING_KLIBC_DIR = "${STAGING_DIR_HOST}/klibc"

do_stage() {
        rm -rf "${STAGING_KLIBC_DIR}"
        oe_runmake      'prefix=${STAGING_KLIBC_DIR}' \
                        'bindir=${STAGING_BINDIR}' \
                        'mandir=${STAGING_DIR_HOST}${layout_mandir}' \
                        install
        # The following is sufficient, at least in klibc 1.1.1 to make klcc
        # use the staged libraries and include files.
        sed -i -e 's@^\$prefix = .*$@\$prefix = "${STAGING_KLIBC_DIR}/lib/klibc";@' \
                '${STAGING_BINDIR}/${TARGET_PREFIX}klcc'
        # Perhaps other binaries need to be moved to cross?
        mv '${STAGING_BINDIR}/${TARGET_PREFIX}klcc' '${STAGING_BINDIR_CROSS}'
}
