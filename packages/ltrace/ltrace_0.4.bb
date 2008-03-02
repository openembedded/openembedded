DESCRIPTION = "ltrace shows runtime library call information for dynamically linked executables."
HOMEPAGE = "http://packages.debian.org/unstable/utils/ltrace.html"
SECTION = "devel"
DEPENDS = "binutils libelf"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/l/ltrace/ltrace_0.4.orig.tar.gz \
           ${DEBIAN_MIRROR}/main/l/ltrace/ltrace_0.4-1.diff.gz;patch=1 \
           file://no-usr-include.patch;patch=1"

inherit autotools

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "INSTALL_FILE='$(INSTALL) -p -m 0644' \
		INSTALL_PROGRAM='$(INSTALL) -p -m 0755' \
		INSTALL_SCRIPT='$(INSTALL) -p -m 0755' \
		INSTALL_DIR='$(INSTALL) -p -d -m 0755' "

export TARGET_CFLAGS = "${SELECTED_OPTIMIZATION} -isystem ${STAGING_INCDIR}"

do_configure_prepend() {
	ln -sf ./linux-gnu sysdeps/linux-gnueabi
}

do_compile() {
	case ${TARGET_ARCH} in
		alpha*)   LTRACE_ARCH=alpha ;;
		arm*)     LTRACE_ARCH=arm ;;
		cris*)    LTRACE_ARCH=cris ;;
		hppa*)    LTRACE_ARCH=parisc ;;
		i*86*)    LTRACE_ARCH=i386 ;;
		ia64*)    LTRACE_ARCH=ia64 ;;
		mips*)    LTRACE_ARCH=mips ;;
		m68k*)    LTRACE_ARCH=m68k ;;
		powerpc*) LTRACE_ARCH=ppc ;;
		s390*)    LTRACE_ARCH=s390 ;;
		sh*)      LTRACE_ARCH=sh ;;
		sparc64*) LTRACE_ARCH=sparc64 ;;
		sparc*)   LTRACE_ARCH=sparc ;;
		x86_64*)  LTRACE_ARCH=x86_64 ;;
	esac
	oe_runmake LDFLAGS=${TARGET_LDFLAGS} LIBS="-lsupc++ -liberty -Wl,-Bstatic -lelf -Wl,-Bdynamic" ${EXTRA_OEMAKE} ARCH=${LTRACE_ARCH}
}

do_install() {
	case ${TARGET_ARCH} in
		alpha*)   LTRACE_ARCH=alpha ;;
		arm*)     LTRACE_ARCH=arm ;;
		cris*)    LTRACE_ARCH=cris ;;
		hppa*)    LTRACE_ARCH=parisc ;;
		i*86*)    LTRACE_ARCH=i386 ;;
		ia64*)    LTRACE_ARCH=ia64 ;;
		mips*)    LTRACE_ARCH=mips ;;
		m68k*)    LTRACE_ARCH=m68k ;;
		powerpc*) LTRACE_ARCH=ppc ;;
		s390*)    LTRACE_ARCH=s390 ;;
		sh*)      LTRACE_ARCH=sh ;;
		sparc64*) LTRACE_ARCH=sparc64 ;;
		sparc*)   LTRACE_ARCH=sparc ;;
		x86_64*)  LTRACE_ARCH=x86_64 ;;
	esac
	oe_runmake install ${EXTRA_OEMAKE} ARCH=${LTRACE_ARCH} INSTALL=${STAGING_BINDIR_NATIVE}/install DESTDIR=${D}
}
