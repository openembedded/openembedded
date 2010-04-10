inherit native
include tk_8.4.19.bb
DEPENDS = "tcl-native"

do_stage() {
        oe_libinstall -a libtkstub8.4 ${STAGING_LIBDIR}
        oe_libinstall -so libtk8.4 ${STAGING_LIBDIR}
        sed -i "s+${WORKDIR}+${STAGING_INCDIR}+g" tkConfig.sh
        install -m 0755 tkConfig.sh ${STAGING_BINDIR}
	install -m 0755 wish ${STAGING_BINDIR}/wish8.4
	ln -s wish8.4 ${STAGING_BINDIR}/wish
	cd ..
	#for dir in compat generic unix
	#do
	#	install -d ${STAGING_INCDIR}/tk${PV}/$dir
	#install -m 0644 $dir/*.h ${STAGING_INCDIR}/tk${PV}/$dir/
	#done
	install -m 0644 generic/tk.h ${STAGING_INCDIR}
	install -m 0644 generic/tkDecls.h ${STAGING_INCDIR}
	install -m 0644 generic/tkPlatDecls.h ${STAGING_INCDIR}

}

SRC_URI[md5sum] = "9b998d0456d1b956eb9da610837a9c47"
SRC_URI[sha256sum] = "d056fe6c204ac31539616e1069522dd5864a580b64e521fe1a49bc895ca8699f"
