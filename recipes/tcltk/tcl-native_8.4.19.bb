inherit native
include tcl_8.4.19.bb

do_stage() {
	oe_libinstall -a libtclstub8.4 ${STAGING_LIBDIR}
	oe_libinstall -so libtcl8.4 ${STAGING_LIBDIR}
	sed -i "s+${WORKDIR}+${STAGING_INCDIR}+g" tclConfig.sh
        sed -i "s,-L${libdir},," tclConfig.sh
	install -d ${STAGING_BINDIR}/
	install -m 0755 tclConfig.sh ${STAGING_BINDIR}
	install -m 0755 tclsh ${STAGING_BINDIR}/tclsh8.4
        ln -s -f tclsh8.4 ${STAGING_BINDIR}/tclsh
	cd ..
	for dir in compat generic unix
	do
		install -d ${STAGING_INCDIR}/tcl${PV}/$dir
		install -m 0644 $dir/*.h ${STAGING_INCDIR}/tcl${PV}/$dir/
	done
	install -m 0644 generic/tcl.h ${STAGING_INCDIR}
	install -m 0644 generic/tclDecls.h ${STAGING_INCDIR}
	install -m 0644 generic/tclPlatDecls.h ${STAGING_INCDIR}
}
