# We want cross packages to be relocatable
inherit relocatable

# Cross packages are built indirectly via dependency,
# no need for them to be a direct target of 'world'
EXCLUDE_FROM_WORLD = "1"

# In order to keep TARGET_PREFIX decoupled from TARGET_SYS, let's force the
# binary names to match the former, rather than relying on autoconf's implicit
# prefixing based on the latter.
EXTRA_OECONF_append = " --program-prefix=${TARGET_PREFIX}"

# Save PACKAGE_ARCH before changing HOST_ARCH
OLD_PACKAGE_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${OLD_PACKAGE_ARCH}"
# Also save BASE_PACKAGE_ARCH since HOST_ARCH can influence it
OLD_BASE_PACKAGE_ARCH := "${BASE_PACKAGE_ARCH}"
BASE_PACKAGE_ARCH = "${OLD_BASE_PACKAGE_ARCH}"

HOST_ARCH = "${BUILD_ARCH}"
HOST_VENDOR = "${BUILD_VENDOR}"
HOST_OS = "${BUILD_OS}"
HOST_PREFIX = "${BUILD_PREFIX}"
HOST_CC_ARCH = "${BUILD_CC_ARCH}"
HOST_EXEEXT = "${BUILD_EXEEXT}"
BASEPKG_HOST_SYS = "${HOST_ARCH}${HOST_VENDOR}-${HOST_OS}"

CPPFLAGS = "${BUILD_CPPFLAGS}"
CFLAGS = "${BUILD_CFLAGS}"
CXXFLAGS = "${BUILD_CFLAGS}"
LDFLAGS = "${BUILD_LDFLAGS}"
LDFLAGS_build-darwin = "-L${STAGING_LIBDIR_NATIVE}"

TOOLCHAIN_OPTIONS = ""

DEPENDS_GETTEXT = "gettext-native"

# Path mangling needed by the cross packaging
# Note that we use := here to ensure that libdir and includedir are
# target paths, not CROSS_DIR paths.
target_libdir := "${libdir}"
target_includedir := "${includedir}"
target_base_libdir := "${base_libdir}"
target_prefix := "${prefix}"

# Overrides for paths
base_prefix = "${STAGING_DIR_NATIVE}"
prefix = "${base_prefix}${prefix_native}/${BASE_PACKAGE_ARCH}"
exec_prefix = "${prefix}"
base_sbindir = "${base_prefix}/bin"
sbindir = "${exec_prefix}/bin"

# staging should be special for cross
STAGING_DIR_HOST = ""
SHLIBSDIR = "${STAGING_DIR_NATIVE}/shlibs"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

#
# Override the default sysroot staging copy since this won't look like a target system
#
sysroot_stage_all() {
	sysroot_stage_dir ${D} ${SYSROOT_DESTDIR}
	install -d ${SYSROOT_DESTDIR}${STAGING_DIR_TARGET}${target_base_libdir}/
	install -d ${SYSROOT_DESTDIR}${STAGING_DIR_TARGET}${target_libdir}/  
	if [ -d ${SYSROOT_DESTDIR}${target_base_libdir} ]; then
		sysroot_stage_libdir ${SYSROOT_DESTDIR}${target_base_libdir} ${SYSROOT_DESTDIR}${STAGING_DIR_TARGET}${target_base_libdir}
	fi
	if [ -d ${SYSROOT_DESTDIR}${target_libdir} ]; then
		sysroot_stage_libdir ${SYSROOT_DESTDIR}${target_libdir} ${SYSROOT_DESTDIR}${STAGING_DIR_TARGET}${target_libdir}
	fi
}

#
# Cross .la files have more path issues we have to correct only for libtool < 2.4
SYSROOTEXTRALIBDIRSED_OLD = " -e \"/^libdir=/s,.*,libdir=${target_libdir},g\" -e \"/^dependency_libs=/s,\([[:space:]']\)-L${STAGING_LIBDIR_NATIVE},,g\""

SYSROOTEXTRALIBDIRSED = "${@["${SYSROOTEXTRALIBDIRSED_OLD}",""][("${LIBTOOL_HAS_SYSROOT}" == "yes")]}"
