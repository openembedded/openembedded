DESCRIPTION = "ltrace shows runtime library call information for dynamically linked executables."
HOMEPAGE = "http://ltrace.alioth.debian.org"
SECTION = "devel"
DEPENDS = "libelf"
LICENSE = "GPLv2"

SRC_URI = "\
  ${DEBIAN_MIRROR}/main/l/ltrace/ltrace_${PV}.orig.tar.gz \
  ${DEBIAN_MIRROR}/main/l/ltrace/ltrace_${PV}-2.diff.gz;patch=1 \
  file://add-sysdep.patch;patch=1 \
  file://ltrace-compile.patch;patch=1 \
  file://ltrace-mips-remove-CP.patch;patch=1 \
  file://ltrace-mips.patch;patch=1 \
  file://ltrace-ppc.patch;patch=1 \
"
inherit autotools

export TARGET_CFLAGS = "${SELECTED_OPTIMIZATION} -isystem ${STAGING_INCDIR}"
TARGET_CC_ARCH += "${LDFLAGS}"

do_configure_prepend() {
	case ${TARGET_ARCH} in
		arm*)  ln -sf ./linux-gnu sysdeps/linux-gnueabi ;;
		mips)  ln -sf ./mipsel sysdeps/linux-gnu/mips ;;
	esac
	sed -e 's:uname -m:echo @HOST_CPU@:' \
		sysdeps/linux-gnu/Makefile > sysdeps/linux-gnu/Makefile.in

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
	oe_runmake install ${EXTRA_OEMAKE} ARCH=${LTRACE_ARCH} DESTDIR=${D}
}
