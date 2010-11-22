DESCRIPTION = "A C++ standard library targeted towards the embedded \
systems/software market."
HOMEPAGE = "http://cxx.uclibc.org/"
LICENSE = "LGPLv2+"
PRIORITY = "optional"
SECTION = "libs"

PR = "r0"

SRCREV = "7efcc107b6bf7a59a85beaf7c7f35da6de0f321e"

SRC_URI = "git://git.busybox.net/uClibc++;protocol=git \
	   file://006-eabi_fix.patch \
	   file://defconfig"
S = "${WORKDIR}/git"

# uClibc++ runtime prefix directory (UCLIBCXX_RUNTIME_PREFIX) [/usr/$(TARGET_ARCH)-linux-uclibc] (NEW)
# uClibc++ header file subdirectory (UCLIBCXX_RUNTIME_INCLUDE_SUBDIR) [/include] (NEW)
# uClibc++ library subdirectory (UCLIBCXX_RUNTIME_LIB_SUBDIR) [/lib] (NEW)
# uClibc++ application file subdirectory (UCLIBCXX_RUNTIME_BIN_SUBDIR) [/bin] (NEW)

EXTRA_OEMAKE = "'OPTIMIZATION=' 'XWARNINGS=' 'XARCH_CFLAGS=${CFLAGS}' \
		'CPU_FLAGS=' 'STRIPTOOL=true' 'LD=${LD}'"
configmangle = 's,^UCLIBCXX_RUNTIME_PREFIX=.*,UCLIBCXX_RUNTIME_PREFIX="${exec_prefix}",; \
		s,^UCLIBCXX_RUNTIME_INCLUDE_SUBDIR=.*,UCLIBCXX_RUNTIME_INCLUDE_SUBDIR="/include/c++-uc",; \
		s,^UCLIBCXX_RUNTIME_LIB_SUBDIR=.*,UCLIBCXX_RUNTIME_LIB_SUBDIR="/lib",; \
		s,^UCLIBCXX_RUNTIME_BIN_SUBDIR=.*,UCLIBCXX_RUNTIME_BIN_SUBDIR="/bin",;'
PARALLEL_MAKE = ""

do_configure () {
	cp ${WORKDIR}/defconfig ${S}/.config

	perl -i -p -e 's,^CROSS=.*,TARGET_ARCH=${TARGET_ARCH}\nCROSS=${TARGET_PREFIX},g' ${S}/Rules.mak
	perl -i -p -e '${configmangle}' ${S}/.config

	oe_runmake oldconfig
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	chmod +x ${D}${libdir}/libuClibc++.so.*
}

PACKAGES = "g++-uc libuclibc++ libuclibc++-dev"
FILES_g++-uc = "${bindir}/g++-uc"
FILES_libuclibc++ = "${libdir}/*.so.*"
FILES_libuclibc++-dev = "${FILES_uclibc++-dev}"
