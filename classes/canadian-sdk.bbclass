#
# Note this class is deprecated and replaced by crosssdk.bbclass
#

# Canadian SDK packages are built either explicitly by the user,
# or indirectly via dependency.  No need to be in 'world'.
EXCLUDE_FROM_WORLD = "1"

inherit canadian

PACKAGE_ARCH = "${SDK_SYS}-sdk-${OLD_PACKAGE_ARCH}"
BASE_PACKAGE_ARCH = "${OLD_BASE_PACKAGE_ARCH}"

HOST_ARCH = "${SDK_ARCH}"
HOST_VENDOR = "${SDK_VENDOR}"
HOST_OS = "${SDK_OS}"
HOST_PREFIX = "${SDK_PREFIX}"
HOST_CC_ARCH = "${SDK_CC_ARCH}"
HOST_EXEEXT = "${SDK_EXEEXT}"

CPPFLAGS = "${SDK_CPPFLAGS}"
CFLAGS = "${SDK_CFLAGS}"
CXXFLAGS = "${SDK_CFLAGS}"
LDFLAGS = "${SDK_LDFLAGS}"

DEPENDS_prepend = "virtual/${HOST_PREFIX}binutils virtual/${HOST_PREFIX}gcc "

# On mingw systems we want to have the real sysroot default to c:/... and
# assume that the default install will be on the C drive.  This can be changed
# by setting SDK_REALPATH_MINGW.
SDK_REALPATH = "${SDK_PATH}"
SDK_REALPATH_MINGW ?= "C:"

# Path prefixes
prefix = "${SDK_PATH}"
exec_prefix = "${prefix}"
base_prefix = "${prefix}"

# Base paths
export base_bindir = "${prefix}/bin"
export base_sbindir = "${prefix}/bin"
export base_libdir = "${prefix}/lib"

# Architecture independent paths
export datadir = "${prefix}/share"
export sysconfdir = "${prefix}/etc"
export sharedstatedir = "${datadir}/com"
export localstatedir = "${prefix}/var"
export infodir = "${datadir}/info"
export mandir = "${datadir}/man"
export docdir = "${datadir}/doc"
export servicedir = "${prefix}/srv"

# Architecture dependent paths
export bindir = "${prefix}/bin"
export sbindir = "${prefix}/bin"
export libexecdir = "${prefix}/libexec"
export libdir = "${prefix}/lib"
export includedir = "${prefix}/include"
export oldincludedir = "${prefix}/include"

export dollar = "$"

canadian_sdk_runconf() {
	# modified oe_runconf()
	# 1. Override prefix with SDK_REALPATH
	# 2. Pass '${prefix}' to configure, to allow for prefix override
	# 3. But don't do that for infodir and mandir, as they will
	#    break gcc makefiles for windows/dos SDK_REALPATH
	if [ -x ${S}/configure ] ; then
		cfgcmd="${S}/configure \
		    --build=${BUILD_SYS} \
		    --host=${HOST_SYS} \
		    --target=${TARGET_SYS} \
		    --prefix=${SDK_REALPATH} \
		    --exec-prefix=$dollar{prefix} \
		    --bindir=$dollar{prefix}/bin \
		    --sbindir=$dollar{prefix}/bin \
		    --libexecdir=$dollar{prefix}/libexec \
		    --datadir=$dollar{prefix}/share \
		    --sysconfdir=$dollar{prefix}/etc \
		    --sharedstatedir=$dollar{prefix}/com \
		    --localstatedir=$dollar{prefix}/var \
		    --libdir=$dollar{prefix}/lib \
		    --includedir=$dollar{prefix}/include \
		    --oldincludedir=$dollar{prefix}/include \
		    --infodir=${prefix}/share/info \
		    --mandir=${prefix}/share/man \
		    --enable-mainainer-mode \
		    ${EXTRA_OECONF} \
		    $@"
		oenote "Running $cfgcmd..."
		$cfgcmd || oefatal "oe_runconf failed"
	else
		oefatal "no configure script found"
	fi
}

FILES_${PN} = "${prefix}"
FILES_${PN}-dbg += "${prefix}/.debug \
                    ${prefix}/bin/.debug \
                   "
