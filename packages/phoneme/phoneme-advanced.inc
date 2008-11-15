DESCRIPTION = "A free CDC JavaVM and class library from Sun Microsystems."
LICENSE = "GPLv2"
HOMEPAGE = "https://phoneme.dev.java.net"
AUTHOR = "Sun Microsystems, Inc."

DEPENDS = "classpath-tools-native virtual/javac-native linux-libc-headers"

inherit java update-alternatives

# The PhoneME Advanced build system is documented here: http://java.sun.com/javame/reference/docs/cdc_build_system.pdf
# NOTE: We need to provide an empty password. pswd='' seems not to be the correct way.
SRC_URI = "\
	svn://guest:''@phoneme.dev.java.net/svn/phoneme/builds/phoneme_advanced-mr2-dev-${BUILDREV};module=cdc;proto=https;localdir=cdc \
	svn://guest:''@phoneme.dev.java.net/svn/phoneme/builds/phoneme_advanced-mr2-dev-${BUILDREV};module=tools;proto=https;localdir=tools \
	svn://guest:''@phoneme.dev.java.net/svn/phoneme;module=legal;localdir=legal;proto=https \
	"

PROVIDES = "virtual/java-cdc java-cdc-runtime"
PRIORITY = "optional"
SECTION  = "interpreters"

# PhoneME builds currently cannot be parallel
PARALLEL_MAKE = ""

S = "${WORKDIR}"

BUILDREV = ${@bb.fatal('BUILDREV is not defined in this phoneme-advanced recipe!')}
SRCREV = ${@bb.fatal('SRCREV is not defined in this phoneme-advanced recipe!')}

COMMON_DIR  = "${libdir_jvm}/${PN}"

PME_PROFILE ?= "foundation"

do_compile() {
	set_arch
	oe_runmake -C cdc/build/linux-$ARCH-generic bin
}

do_install() {
	install -d ${D}/${libdir_jvm}

	unzip cdc/install/${PN}.zip -d ${D}/${libdir_jvm}

	# Additional link named cvm-${PME_PROFILE}
	install -d ${D}/${bindir}
	ln -sf ${libdir_jvm}/${PN}/bin/cvm ${D}${bindir}/cvm-${PME_PROFILE}
}

do_configure() {
  set_arch
  test ! -d cdc/build/linux-$ARCH-generic && mkdir -p cdc/build/linux-$ARCH-generic
  cd cdc/build/linux-$ARCH-generic

  echo "Configuring PhoneME Advanced build"
  pmo_start J2ME_CLASSLIB ${PME_PROFILE}

  # Dispatch to arch-specific functions.
  oe_phoneme_config$ARCH

  oe_phoneme_configbase

  pmo "# Misc locations and file names."
  pmo BINARY_BUNDLE_NAME ${PN}
  pmo BINARY_BUNDLE_APPEND_REVISION false
  pmo JAVAME_LEGAL_DIR ${WORKDIR}/legal

  pmo "# Java toolchain binaries"
  pmo JDK_HOME /dev/null
  pmo CVM_TARGET_TOOLS_PREFIX ${CROSS_DIR}/bin/
  pmo CVM_JAVA java
  pmo CVM_JAVAC javac
  pmo CVM_JAVADOC true
  pmo CVM_JAVAH gjavah
  pmo CVM_JAR gjar
  pmo CVM_INCLUDE_DIR ${STAGING_INCDIR}/classpath

  pmo JAVAC_OPTIONS -nowarn

  pmo "# Host C/C++ toolchain binaries"
  pmo HOST_CC "${BUILD_CC}"
  pmo HOST_CC_PATH "${BUILD_CC}"
  pmo HOST_CCC "${BUILD_CXX}"
  pmo HOST_PATH "${BUILD_CXX}"
  pmo HOST_LD "${BUILD_LD}"
  pmo HOST_RANLIB "${BUILD_RANLIB}"

  pmo "# C/C++ toolchain binaries"
  pmo TARGET_CC "${CC}"
  pmo TARGET_CC_PATH "${CC}"
  pmo CCFLAGS "${CFLAGS}"
  pmo TARGET_CCC "${CXX}"
  pmo TARGET_PATH "${CXX}"
  pmo CCCFLAGS "${CXXFLAGS}"
  pmo TARGET_AR "${AR}"
  pmo TARGET_LD "${CC}"
  pmo TARGET_RANLIB "${RANLIB}"

  pmo USE_GCC2 false

  pmo "include ../share/top.mk"
}

pmo_start() {
	echo "$1 = $2" > GNUmakefile
	echo "$1 = $2"
}

pmo() {
	if [ "$2" ]
	then
		echo "$1 = $2" >> GNUmakefile
		echo "$1 = $2"
	else
		echo "$1" >> GNUmakefile
		echo "$1"
	fi
}

set_arch() {
	case ${TARGET_ARCH} in
		arm*)     ARCH=arm ;;
		i*86*)    ARCH=x86 ;;
		mips*)    ARCH=mips ;;
		powerpc*) ARCH=powerpc ;;
		sparc*)   ARCH=sparc ;;
		x86_64*)  ARCH=x86 ;;
		*)    die "Sorry, your target architecture is not supported!" ;;
	esac
}

# Default non-arch specific configuration
oe_phoneme_configbase() {
  pmo CVM_DEBUG false
  pmo CVM_JIT true
}

# Default arch specific configurations
oe_phoneme_configarm() {
	tf=true
	if [ Xoabi = X${ARM_ABI} ]
	then
		tf=false
	fi

	pmo USE_AAPCS $tf
}

oe_phoneme_configx86() {
	# Taken from linux-x86-generic/GNUmakefile
	pmo CVM_JIT_REGISTER_LOCALS false
}

ALTERNATIVE_NAME = "java-cdc"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"
ALTERNATIVE_PATH = "${libdir}/jvm/${PN}/bin/cvm"
ALTERNATIVE_PRIORITY = "10"

FILES_${PN} = "${bindir}"
FILES_${PN}-dbg += "${COMMON_DIR}/bin/.debug/cvm"

