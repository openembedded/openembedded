DESCRIPTION = "ltrace shows runtime library call information for dynamically linked executables."
HOMEPAGE = "http://packages.debian.org/unstable/utils/ltrace.html"
SECTION = "devel"
DEPENDS = "libelf"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.debian.org/debian/pool/main/l/ltrace/ltrace_0.3.36.orig.tar.gz\
           ftp://ftp.debian.org/debian/pool/main/l/ltrace/ltrace_0.3.36-2.diff.gz;patch=1\
	   file://mvc-toolchain.patch;patch=1"

inherit autotools

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "ARCH=${TARGET_ARCH} \
		INSTALL_FILE='$(INSTALL) -p -m 0644' \
		INSTALL_PROGRAM='$(INSTALL) -p -m 0755' \
		INSTALL_SCRIPT='$(INSTALL) -p -m 0755' \
		INSTALL_DIR='$(INSTALL) -p -d -m 0755' "

export TARGET_CFLAGS = "${SELECTED_OPTIMIZATION} -isystem ${STAGING_DIR}/${TARGET_SYS}/include"

do_compile() {
	oe_runmake LDFLAGS=${TARGET_LDFLAGS} LIBS="-lsupc++ -liberty -Wl,-Bstatic -lelf -Wl,-Bdynamic" ${EXTRA_OEMAKE}
}
