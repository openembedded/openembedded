DESCRIPTION = "A C++ standard library targeted towards the embedded \
systems/software market."
HOMEPAGE = "http://cxx.uclibc.org/"
LICENSE = "LGPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "libs"

PR = "r1"

SRC_URI = "http://cxx.uclibc.org/src/uClibc++-${PV}.tbz2 \
	   file://nobash.patch;patch=1 \
	   file://defconfig"
S = "${WORKDIR}/uClibc++"

# uClibc++ runtime prefix directory (UCLIBCXX_RUNTIME_PREFIX) [/usr/$(TARGET_ARCH)-linux-uclibc] (NEW) 
# uClibc++ header file subdirectory (UCLIBCXX_RUNTIME_INCLUDE_SUBDIR) [/include] (NEW) 
# uClibc++ library subdirectory (UCLIBCXX_RUNTIME_LIB_SUBDIR) [/lib] (NEW)
# uClibc++ application file subdirectory (UCLIBCXX_RUNTIME_BIN_SUBDIR) [/bin] (NEW) 

do_unpack_real () {
	bzcat uClibc++-${PV}.tbz2 | tar -xvf -
}
do_unpack_real[dirs] = "${WORKDIR}"
addtask unpack_real before do_patch after do_unpack

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

do_stage () {
	oe_runmake 'UCLIBCXX_RUNTIME_PREFIX=${STAGING_LIBDIR}/../' \
		   install
	chmod +x ${STAGING_LIBDIR}/libuClibc++.so.*
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	chmod +x ${D}${libdir}/libuClibc++.so.*
}

PACKAGES = "g++-uc libuclibc++ libuclibc++-dev"
FILES_g++-uc = "${bindir}/g++-uc"
FILES_libuclibc++ = "${libdir}/*.so.*"
FILES_libuclibc++-dev = "${FILES_uclibc++-dev}"
