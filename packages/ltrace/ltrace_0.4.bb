DESCRIPTION = "ltrace shows runtime library call information for dynamically linked executables."
HOMEPAGE = "http://packages.debian.org/unstable/utils/ltrace.html"
SECTION = "devel"
DEPENDS = "libelf"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.debian.org/debian/pool/main/l/ltrace/ltrace_0.4.orig.tar.gz \
           ftp://ftp.debian.org/debian/pool/main/l/ltrace/ltrace_0.4-1.diff.gz;patch=1"
inherit autotools

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "ARCH=${LTRACE_ARCH} \
		INSTALL_FILE='$(INSTALL) -p -m 0644' \
		INSTALL_PROGRAM='$(INSTALL) -p -m 0755' \
		INSTALL_SCRIPT='$(INSTALL) -p -m 0755' \
		INSTALL_DIR='$(INSTALL) -p -d -m 0755' "

export TARGET_CFLAGS = "${SELECTED_OPTIMIZATION} -isystem ${STAGING_DIR}/${TARGET_SYS}/include"

LTRACE_ARCH = ${TARGET_ARCH}
LTRACE_ARCH_x86 = "i386"

do_configure_prepend() {
	ln -sf ./linux-gnu sysdeps/linux-gnueabi
}

do_compile() {
	oe_runmake LDFLAGS=${TARGET_LDFLAGS} LIBS="-lsupc++ -liberty -Wl,-Bstatic -lelf -Wl,-Bdynamic" ${EXTRA_OEMAKE}
}
