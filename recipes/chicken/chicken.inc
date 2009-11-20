ESCRIPTION = "A compiler that translates Scheme source files to C, and an interpreter"
HOMEPAGE = "http://www.call-with-current-continuation.org/"
SECTION = "interpreters"
PRIORITY = "optional"
LICENSE = "BSD"
INC_PR = "r2"

SRC_URI = "http://chicken.wiki.br/releases/${PV}/chicken-${PV}.tar.gz"

# Parallel building is not supported
PARALLEL_MAKE = ""

# Required environment values
export PLATFORM="linux"
export PREFIX="${prefix}"
export HOSTSYSTEM="${HOST_SYS}"
export TARGETSYSTEM="${TARGET_SYS}"
export INSTALL_PROGRAM_SHARED_LIBRARY_OPTIONS="-m 755"
export INSTALL_PROGRAM_STATIC_LIBRARY_OPTIONS="-m 644"
export INSTALL_PROGRAM_EXECUTABLE_OPTIONS="-m 755"
export INSTALL_PROGRAM_FILE_OPTIONS="-m 644"

do_compile() {
	case ${TARGET_ARCH} in
	i*86)
		ARCH=x86
		;;
	x86_64)
		ARCH=x86-64
		;;
	*)
		echo "Check ARCH value for ${TARGET_ARCH}"
		exit 1
		;;
	esac

    make ARCH=${ARCH} TARGET_C_COMPILER=gcc
}

do_install() {
	case ${TARGET_ARCH} in
	i*86)
		ARCH=x86
		;;
	x86_64)
		ARCH=x86-64
		;;
	*)
		echo "Check ARCH value for ${TARGET_ARCH}"
		exit 1
		;;
	esac

    make ARCH=${ARCH} DESTDIR=${D} install
}

PACKAGES += "chicken-bin libchicken libuchicken"

FILES_${PN} = ""
FILES_libchicken = "${libdir}/libchicken.so.*"
FILES_libuchicken = "${libdir}/libuchicken.so.*"
FILES_${PN}-bin = "${bindir}/* ${datadir}/chicken/*.* ${libdir}/chicken/*/*.so"
FILES_${PN}-doc += "${datadir}/chicken/doc"
FILES_${PN}-dbg += "${libdir}/chicken/*/.debug"
