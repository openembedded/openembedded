require dietlibc-common.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "gcc-native virtual/${TARGET_PREFIX}gcc \
            virtual/${TARGET_PREFIX}binutils"

CFLAGS += "-fno-exceptions -std=gnu99 -Os -Wall -Wmissing-prototypes"
_target_test_cflags = "${CFLAGS} -L ${S}/bin-${DIETLIBC_TARGET_ARCH} \
    -fno-builtin"

do_compile () {
    ln -sf dietfeatures-build.h dietfeatures.h
    oe_runmake all ARCH="${DIETLIBC_BUILD_ARCH}"  \
        CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}" \
        WHAT='$(OBJDIR)/diet'

    ln -sf dietfeatures-target.h dietfeatures.h
    oe_runmake all profiling ARCH="${DIETLIBC_TARGET_ARCH}" \
        CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install () {
    dietlibc_install_dev
    install -D -p -m 0755 bin-${DIETLIBC_TARGET_ARCH}/diet-i ${D}${bindir}/diet
}

dietlibc_build_tests () {
    rc=0
    # Allow to build as much as possible and return an error code when
    # something went wrong
    ( oe_runmake -C test all test DIET=${S}/bin-${DIETLIBC_BUILD_ARCH}/diet \
        CC="${CC}" CFLAGS="${_target_test_cflags}" LDFLAGS="${LDFLAGS}" \
        "$@" ) || rc=$?

    ( oe_runmake -C test/inet all DIET=${S}/bin-${DIETLIBC_BUILD_ARCH}/diet \
        CC="${CC}" CFLAGS="${_target_test_cflags}" LDFLAGS="${LDFLAGS}" \
        "$@" ) || rc=$?

    return $rc
}

dietlibc_do_full_test () {
    ## Check for references to __NR_ symbols which indicates missing
    ## syscall implementations
    if ${TARGET_PREFIX}nm bin-${DIETLIBC_TARGET_ARCH}/*.a | grep 'U __NR_' >&2; then
        echo "ERROR: unimplemented syscalls found" >&2
        exit 1
    fi


    ## Build and run the testsuite (when emulator is available)
    dietlibc_build_tests

    if type -p "$QEMU" && test x"$QEMU" != x"false"; then
       cd test
       env EMULATOR="${QEMU} ${QEMU_OPTIONS}" bash ${WORKDIR}/runtests-X.sh
       cd -
    fi
}
