require binutils_cvs.bb
require binutils-cross-sdk.inc

PV = "2.20+cvs${SRCDATE}"

PR = "${INC_PR}.2"
FILESPATHPKG .= ":binutils-cvs"

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
