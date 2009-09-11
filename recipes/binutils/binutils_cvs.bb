FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
PV = "2.20+cvs${SRCDATE}"
INC_PR = "r5"
PR = "${INC_PR}.1"

require binutils.inc

S = "${WORKDIR}/src"
EXTRA_OEMAKE = "configure-build-libiberty"
SRC_URI = "cvs://anoncvs:anoncvs@sources.redhat.com/cvs/src;module=binutils;method=pserver;localdir=src \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1;maxdate=20090801 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
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

do_stage () {
        oe_libinstall -so -a -C opcodes libopcodes ${STAGING_LIBDIR}/
        oe_libinstall -a -C libiberty libiberty ${STAGING_LIBDIR}/
        oe_libinstall -so -a -C bfd libbfd ${STAGING_LIBDIR}/
        install -m 0644 ${S}/include/dis-asm.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/symcat.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/libiberty.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/ansidecl.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/bfdlink.h ${STAGING_INCDIR}/
        install -m 0644 bfd/bfd.h ${STAGING_INCDIR}/
}
