FILESPATHPKG =. "binutils-cvs:"
SRCDATE = "20100913"
PV = "2.20+cvs${SRCDATE}"

require binutils.inc
PR = "${INC_PR}.2"

S = "${WORKDIR}/src"
EXTRA_OEMAKE = "configure-build-libiberty"
SRC_URI = "cvs://anoncvs:anoncvs@sources.redhat.com/cvs/src;module=binutils;method=pserver;localdir=src \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;maxdate=20090801 \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://110-arm-eabi-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     "

do_compile () {
	oe_runmake all-ld all-binutils all-gas
}
do_install () {
        oe_runmake 'DESTDIR=${D}' install-ld install-binutils install-gas

        # We don't really need these, so we'll remove them...
        rm -rf ${D}${libdir}/ldscripts

        # Fix the /usr/${TARGET_SYS}/bin/* links
        for l in ${D}${prefix}/${TARGET_SYS}/bin/*; do
                rm -f $l
                ln -sf `echo ${prefix}/${TARGET_SYS}/bin \
                        | tr -s / \
                        | sed -e 's,^/,,' -e 's,[^/]*,..,g'`${bindir}/${TARGET_PREFIX}`basename $l` $l
        done

        # Install the libiberty header
        install -d ${D}${includedir}
        install -m 644 ${S}/include/ansidecl.h ${D}${includedir}
        install -m 644 ${S}/include/libiberty.h ${D}${includedir}

        cd ${D}${bindir}

        # Symlinks for ease of running these on the native target
        for p in ${TARGET_SYS}-* ; do
                ln -sf $p `echo $p | sed -e s,${TARGET_SYS}-,,`
        done

        rm ${D}${bindir}/ar ${D}${bindir}/strings
}

