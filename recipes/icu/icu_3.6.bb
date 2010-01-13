require icu-3.6.inc

DEPENDS += "icu-native"
PR = "${INC_PR}.1"

SRC_URI += "file://use-g++-for-linking.patch;patch=1 \
            file://rematch-gcc-bug.patch;patch=1"

do_configure_append() {
        for i in */Makefile */*.inc */*/Makefile */*/*.inc icudefs.mk ; do
		sed -i -e 's:$(INVOKE) $(BINDIR)/:$(INVOKE) :g' $i 
		sed -i -e 's:$(BINDIR)/::g' $i 
		sed -i -e 's:LD_LIBRARY_PATH:LD_LIBRARY_PATH_FAKE:g' $i
        done
	sed -i -e 's:$(BINDIR)/::g' extra/uconv/pkgdata.inc || true
	sed -i -e 's:$(BINDIR)/::g' extra/uconv/pkgdata.inc.in || true
}

do_compile() {
	oe_runmake 'CXX=${CXX}'
}

do_install_append() {
        chmod +x ${D}${libdir}/lib*
}

PACKAGES =+ "libicudata libicuuc libicui18n libicule libiculx libicutu libicuio"

FILES_libicudata = "${libdir}/libicudata.so.*"
FILES_libicuuc = "${libdir}/libicuuc.so.*"
FILES_libicui18n = "${libdir}/libicui18n.so.*"
FILES_libicule = "${libdir}/libicule.so.*"
FILES_libiculx = "${libdir}/libiculx.so.*"
FILES_libicutu = "${libdir}/libicutu.so.*"
FILES_libicuio = "${libdir}/libicuio.so.*"

do_stage() {
        autotools_stage_all
}

SYSROOT_PREPROCESS_FUNCS += "icu_sysroot_preprocess"

# We need to append this so it runs *after* binconfig's preprocess function
icu_sysroot_preprocess () {
        sed -i -e s:^prefix=:prefix=\"${STAGING_DIR_TARGET}/usr\": ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/icu-config
}	


