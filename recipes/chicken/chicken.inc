ESCRIPTION = "A compiler that translates Scheme source files to C, and an interpreter"
HOMEPAGE = "http://www.call-with-current-continuation.org/"
SECTION = "interpreters"
PRIORITY = "optional"
LICENSE = "BSD"
INC_PR = "r1"

SRC_URI = "http://chicken.wiki.br/releases/${PV}/chicken-${PV}.tar.gz"

inherit autotools

# Parallel building is not supported
PARALLEL_MAKE = ""

# Required environment values
export PLATFORM="linux"
export PREFIX="${prefix}"
export C_COMPILER="${TARGET_PREFIX}gcc ${LDFLAGS} "
export LIBRARIAN="${TARGET_PREIX}ar "
export TARGETSYSTEM="${TARGET_SYS}"

SONAME = "${@bb.data.getVar("PV", d, 1)[0]}"
ASSUME_SHLIBS += "libchicken.so.${SONAME}:libchicken libuchicken.so.${SONAME}:libuchicken"

do_compile() {
	case ${TARGET_ARCH} in
	i*86)
		ARCH=x86
		;;
	*)
		echo "Check ARCH value for ${TARGET_ARCH}"
		exit 1
		;;
	esac

    make ARCH=${ARCH}
}

do_install() {
	case ${TARGET_ARCH} in
	i*86)
		ARCH=x86
		;;
	*)
		echo "Check ARCH value for ${TARGET_ARCH}"
		exit 1
		;;
	esac

    make ARCH=${ARCH} DESTDIR=${D} install
}

do_install_append() {
    # Handle lacking of soname is some versions
    if [ ! -e ${D}${libdir}/libchicken.so.${SONAME} ]; then
        (cd ${D}${libdir}
         mv libchicken.so libchicken.so.${SONAME}
         ln -s libchicken.so.${SONAME} libchicken.so
         mv libuchicken.so libuchicken.so.${SONAME}
         ln -s libuchicken.so.${SONAME} libuchicken.so)
    fi
}

PACKAGES += "chicken-bin libchicken libuchicken"

FILES_${PN} = ""
FILES_libchicken = "${libdir}/libchicken.so.${SONAME}"
FILES_libuchicken = "${libdir}/libuchicken.so.${SONAME}*"
FILES_${PN}-bin = "${bindir}/* ${datadir}/chicken/*.* ${libdir}/chicken/${SONAME}/*.so"
FILES_${PN}-doc += "${datadir}/chicken/doc"
FILES_${PN}-dbg += "${libdir}/chicken/*/.debug"
