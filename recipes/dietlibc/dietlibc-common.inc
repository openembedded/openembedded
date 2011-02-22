DESCRIPTION = "The diet libc is a libc that is optimized for small size. \
It can be used to create small statically linked binaries"
SECTION = "libs"
LICENSE = "GPLv2"
INC_PR = "r1"
PR = "${INC_PR}.0"

EXTRA_OEMAKE = "\
        STRIP=: \
        prefix=${pkglibdir} \
        HOME=\"`pwd`\" \
        MYARCH:='${DIETLIBC_BUILD_ARCH}' \
"

PACKAGES += "${PN}-headers"
RDEPENDS_${PN}-dev += "${PN}-headers (= ${EXTENDPV})"

FILES_${PN} = "${bindir}/*"
FILES_${PN}-headers = "${pkglibdir}/include"
FILES_${PN}-dev = "${pkgarchdir}/*"
FILES_${PN}-dbg += "${pkgarchdir}/.debug"

export DIETLIBC_BUILD_ARCH="${@re.sub('i[0-9]86','i386','${BUILD_ARCH}')}"
export DIETLIBC_TARGET_ARCH="${@re.sub('i[0-9]86','i386','${TARGET_ARCH}')}"

export QEMU = "${@qemu_target_binary(d)}"

pkglibdir = "${libdir}/dietlibc"
pkgarchdir = "${pkglibdir}/lib-${DIETLIBC_TARGET_ARCH}"

do_configure () {
    dietlibc_fix_features "${DIETLIBC_BUILD_ARCH}" dietfeatures-build.h
    dietlibc_fix_features "${DIETLIBC_TARGET_ARCH}" dietfeatures-target.h

    rm -f dietfeatures.h

    # Initialize infrastructure for our tests
    for i in `find test -name 'runtests.sh'`; do
        ln -s ${WORKDIR}/runtests-X.sh `dirname $i`/runtests-X.sh
    done
}

dietlibc_fix_features () {
    arch=$1
    dst=$2

    # LARGEFILE_BACKCOMPAT is some linux 2.2 thing
    set -- -e '/#define \(WANT_LARGEFILE_BACKCOMPAT\|WANT_VALGRIND_SUPPORT\)/d'

    case $arch in
    (x86_64|ppc|ppc64)
    ;;

    (*)
    set -- \
        -e '/#define WANT_DYN_PAGESIZE/{c\'     \
        -e '#define WANT_ELFINFO'               \
        -e '}'
    esac

    sed "$@" dietfeatures.h > "$dst"
}

dietlibc_install_dev () {
    install -d -m 0755 ${D}${pkgarchdir}
    install -d -m 0755 ${D}${pkglibdir}/include

    for i in `find include -name \*.h`; do
        install -D -p -m 0644 $i ${D}${pkglibdir}/$i
    done

    cd bin-${DIETLIBC_TARGET_ARCH}
    install -p -m 0644 \
        start.o libm.a libpthread.a librpc.a liblatin1.a libcompat.a libcrypt.a \
        pstart.o libgmon.a \
        ${D}${pkgarchdir}/

    # extra step because 'dietlibc.a' must be renamed to 'libc.a'
    install -D -p -m 0644 dietlibc.a ${D}${pkgarchdir}/libc.a
    cd -
}
