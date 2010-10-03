SECTION = "devel"
inherit cross
DEPENDS += "flex-native bison-native"
PROVIDES = "virtual/${TARGET_PREFIX}binutils"
PACKAGES = ""
EXTRA_OECONF = "--with-sysroot=${STAGING_DIR_TARGET} \
		--program-prefix=${TARGET_PREFIX} \
		--disable-werror \
	       "
EXTRA_OECONF_append_mips64 = " --enable-64-bit-bfd"
EXTRA_OECONF_append_mips64el = " --enable-64-bit-bfd"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	rm -rf ${D}${prefix}/${TARGET_SYS}
	# We don't really need these, so we'll remove them...
	rm -rf ${D}${prefix}/lib/ldscripts
	rm -rf ${D}${prefix}/share/info
	rm -rf ${D}${prefix}/share/locale
	rm -rf ${D}${prefix}/share/man
	rmdir ${D}${prefix}/share || :
	rmdir ${D}${prefix}/${libdir}/gcc-lib || :
	rmdir ${D}${prefix}/${libdir}64/gcc-lib || :
	rmdir ${D}${prefix}/${libdir} || :
	rmdir ${D}${prefix}/${libdir}64 || :
	rmdir ${D}${prefix}/${prefix} || :
	# Insert symlinks into libexec so when tools without a prefix are searched for, the correct ones are
	# found.
	dest=${D}${prefix}/${TARGET_SYS}${base_bindir_native}
	install -d $dest
	for t in ar as ld nm objcopy objdump ranlib strip; do
		ln -sf ../..${base_bindir_native}/${TARGET_PREFIX}$t $dest/$t
	done
}
