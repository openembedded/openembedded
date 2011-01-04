DESCRIPTION = "C library for embedded systems"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "required"
INC_PR = "r35"
require uclibc-config.inc
#
# For now, we will skip building of a gcc package if it is a uclibc one
# and our build is not a uclibc one, and we skip a glibc one if our build
# is a uclibc build.
#
# See the note in gcc/gcc_3.4.0.oe
#

python __anonymous () {
    import bb, re
    uc_os = (re.match('.*uclibc*', bb.data.getVar('TARGET_OS', d, 1)) != None)
    if not uc_os:
        raise bb.parse.SkipPackage("incompatible with target %s" %
                                   bb.data.getVar('TARGET_OS', d, 1))
}
PROVIDES += "virtual/libc virtual/${TARGET_PREFIX}libc-for-gcc"
DEPENDS = "virtual/${TARGET_PREFIX}binutils \
           virtual/${TARGET_PREFIX}gcc-intermediate \
           linux-libc-headers ncurses-native"
RDEPENDS_${PN}-dev = "linux-libc-headers-dev"

INHIBIT_DEFAULT_DEPS = "1"

PACKAGES =+ "ldd uclibc-utils-dbg uclibc-utils uclibc-gconv uclibc-thread-db"

LEAD_SONAME = "libc.so"

# The last line (gdb and lib1) is for uclinux-uclibc builds
uclibc_baselibs = "${base_libdir}/libcrypt*.so.* ${base_libdir}/libcrypt-*.so \
                   ${base_libdir}/libintl*.so.* ${base_libdir}/libintl-*.so \
                   ${base_libdir}/libnsl*.so.* ${base_libdir}/libnsl-*.so \
                   ${base_libdir}/libresolv*.so.* ${base_libdir}/libresolv-*.so \
                   ${base_libdir}/ld*.so.* ${base_libdir}/ld-*.so \
                   ${base_libdir}/libc*.so.* ${base_libdir}/libuClibc-*.so \
                   ${base_libdir}/libdl*.so.* ${base_libdir}/libdl-*.so \
                   ${base_libdir}/libm*.so.* ${base_libdir}/libm-*.so \
                   ${base_libdir}/libutil*.so.* ${base_libdir}/libutil-*.so \
                   ${base_libdir}/libpthread*.so.* ${base_libdir}/libpthread-*.so \
                   ${base_libdir}/librt*.so.* ${base_libdir}/librt-*.so \
                   ${libdir}/libc.gdb ${libdir}/libc ${base_libdir}/lib1.so \
                  "
FILES_${PN} = "${sysconfdir} ${uclibc_baselibs} /sbin/ldconfig \
               ${libexecdir} ${datadir}/zoneinfo ${libdir}/locale"
FILES_ldd = "${bindir}/ldd"
FILES_uclibc-dev_append = "\
        ${libdir}/lib*.so \
        ${libdir}/*_nonshared.a \
        ${libdir}/[S]*crt[1in].o \
        ${libdir}/crtreloc*.o \
        ${libdir}/lib*.a \
        ${includedir}/*.h ${includedir}/*/*.h \
       "
FILES_uclibc-utils = "${bindir} ${sbindir}"
FILES_uclibc-utils-dbg += "${bindir}/.debug ${sbindir}/.debug"
FILES_uclibc-gconv = "${libdir}/gconv"
FILES_uclibc-thread-db = "/lib/libthread_db*"
RPROVIDES_uclibc-dev += "libc-dev virtual-libc-dev"
# uclibc does not really have libsegfault but then using the one from glibc is also not
# going to work. So we pretend that we have it to make bitbake not pull other recipes
# to satisfy this dependency for the images/tasks
RPROVIDES_${PN} += "libsegfault"

SRC_URI = "\
        file://uClibc.config \
        http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2;name=uClibc-${PV} \
        "

# do_stage barfs on a CC with whitespace, therefore put the 'HOST_CC_ARCH' in
# the CFLAGS (when building the utils).
OEMAKE_NO_CC = "'STRIPTOOL=true' 'LD=${LD}'"
EXTRA_OEMAKE = "${OEMAKE_NO_CC} \
                'HOSTCC=${BUILD_CC}' \
                'HOST_CFLAGS=${BUILD_CFLAGS}' \
                'CC=${CC}' \
                ARCH=${UCLIBC_ARCH}"

EXTRA_OEMAKE_task_do_package = "${OEMAKE_NO_CC}"

# enable verbose output:
export V="2"

# -O<n> -fno-omit-frame-pointer ends up with GCC ICE on thumb as reported
# http://gcc.gnu.org/bugzilla/show_bug.cgi?id=44860
#
CFLAGS_arm := "${@oe_filter_out('-fno-omit-frame-pointer', '${CFLAGS}', d)}"
UCLIBC_EXTRA_CFLAGS  := "${@oe_filter_out('(-I\S+|-i\S+)', '${CFLAGS}', d)}"
UCLIBC_EXTRA_LDFLAGS := "${@oe_filter_out('(-L\S+|-l\S+)', '${LDFLAGS}', d)}"
do_compile_prepend () {
  unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
}

configmangle = '/^KERNEL_HEADERS/d; \
                /^RUNTIME_PREFIX/d; \
                /^DEVEL_PREFIX/d; \
                /^SHARED_LIB_LOADER_PREFIX/d; \
                /^UCLIBC_EXTRA_CFLAGS/d; \
                s,.*UCLIBC_HAS_WCHAR.*,UCLIBC_HAS_WCHAR=y,g; \
                ${@["","s,.*UCLIBC_HAS_LOCALE.*,UCLIBC_HAS_LOCALE=y,;"][bb.data.getVar("USE_NLS", d, 1) == "yes"]} \
                ${@["","s,.*LDSO_GNU_HASH_SUPPORT.*,# LDSO_GNU_HASH_SUPPORT is not set,;"][bb.data.getVar("TARGET_ARCH", d, 1) in ['mips', 'mipsel', 'mips64', 'mips64el', 'avr32']]} \
                /^CROSS/d; \
                /^TARGET_ARCH=/d; \
                /^TARGET_/s,^\([^=]*\).*,# \1 is not set,g; \
                s,^DOSTRIP.*,# DOSTRIP is not set,g; \
                /_[EO]*ABI/d; \
                /HAS_FPU/d; \
               '
OE_FEATURES := "${@features_to_uclibc_conf(d)}"
OE_DEL      := "${@features_to_uclibc_del(d)}"
python () {
  if "${OE_DEL}":
    bb.data.setVar('configmangle_append', "${OE_DEL}" + "\n", d)
  if "${OE_FEATURES}":
    bb.data.setVar('configmangle_append',
                   "/^### DISTRO FEATURES$/a\\\n%s\n\n" %
                   ("\\n".join((bb.data.expand("${OE_FEATURES}", d).split("\n")))),
                   d)
  bb.data.setVar('configmangle_append',
                 "/^### CROSS$/a\\\n%s\n" %
                  ("\\n".join(["CROSS_COMPILER_PREFIX=\"${TARGET_PREFIX}\"",
                        "UCLIBC_EXTRA_CFLAGS=\"${UCLIBC_EXTRA_CFLAGS}\"",
                         "KERNEL_HEADERS=\"${STAGING_INCDIR}\"",
                         "RUNTIME_PREFIX=\"/\"",
                         "DEVEL_PREFIX=\"/${prefix}\"",
                         "SHARED_LIB_LOADER_PREFIX=\"/lib\"",
                        ])
                  ),
                 d)
  bb.data.setVar('configmangle_append',
                 "/^### TGT$/a\\\nTARGET_ARCH=\"%s\"\\nTARGET_%s=y\n" %
                        ("${UCLIBC_ARCH}", "${UCLIBC_ARCH}"),
                 d)
  bb.data.setVar('configmangle_append',
    "/^### FPU$/a\\\n%s\n\n" % (["UCLIBC_HAS_FPU=y","# UCLIBC_HAS_FPU is not set"][bb.data.getVar('TARGET_FPU', d, 1) in [ 'soft' ]]), d)
  if "${UCLIBC_ENDIAN}":
    bb.data.setVar('configmangle_append',
                   "/^### ABI$/a\\\nARCH_%s_ENDIAN=y\n\n" % ("${UCLIBC_ENDIAN}"),
                   d)
  if "${UCLIBC_ABI}":
    bb.data.setVar('configmangle_append',
                   "/^### ABI$/a\\\nCONFIG_%s=y\n\n" % ("${UCLIBC_ABI}"),
                   d)
}

uclibcbuild_do_patch() {
        ln -sf ${STAGING_INCDIR}/linux ${S}/include/linux
        ln -sf ${STAGING_INCDIR}/asm ${S}/include/asm
}

python do_patch () {
        bb.build.exec_func('base_do_patch', d)
        bb.build.exec_func('uclibcbuild_do_patch', d)
}

do_configure() {
        rm -f ${S}/.config

        # OpenEmbedded splits the uClibc.config in two parts:
        # uClibc.machine, uClibc.distro
        # So, if they exist use them, otherwise use a uClibc.config
        if [ -f ${WORKDIR}/uClibc.machine -a -f ${WORKDIR}/uClibc.distro ]; then
                echo "### uClibc.machine ###" >${S}/merged.config
                cat ${WORKDIR}/uClibc.machine >>${S}/merged.config
                echo "### uClibc.distro ###" >>${S}/merged.config
                cat ${WORKDIR}/uClibc.distro >>${S}/merged.config
        else
                echo "### uClibc.config ###" >${S}/merged.config
                cat ${WORKDIR}/uClibc.config >>${S}/merged.config
        fi
        echo "### CROSS" >>${S}/merged.config
        echo "### TGT" >>${S}/merged.config
        echo "### MMU" >>${S}/merged.config
        echo "### FPU" >>${S}/merged.config
        echo "### ABI" >>${S}/merged.config
        echo "### DISTRO FEATURES" >>${S}/merged.config
        cp ${S}/merged.config ${S}/.config

        # Mangle the resulting .config depending on OE variables
        sed -i -e '${configmangle}' ${S}/.config

        oe_runmake oldconfig
}

do_install() {
        oe_runmake PREFIX=${D} install
        oe_runmake PREFIX=${D} "SSP_ALL_CFLAGS=${TARGET_LINK_HASH_STYLE}" install_utils
}

get_monotonic_srcrev () {
        (cd ${S}; eval `git rev-list HEAD|wc -l`)
}
