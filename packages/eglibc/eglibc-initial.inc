SECTION = "libs"
DEPENDS = "linux-libc-headers"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/eglibc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

PACKAGES = ""
PACKAGES_DYNAMIC = ""

do_configure () {
	sed -ie 's,{ (exit 1); exit 1; }; },{ (exit 0); }; },g' ${S}/configure
	chmod +x ${S}/configure
	CC="${BUILD_CC}" CPP="${BUILD_CPP}" LD="${BUILD_LD}" \
	${S}/configure --host=${TARGET_SYS} --build=${BUILD_SYS} \
		--without-cvs --disable-sanity-checks \
		--with-headers=${STAGING_DIR_TARGET}${layout_includedir} \
		--enable-hacker-mode
}

do_compile () {
	:
}

do_stage () {
	oe_runmake cross-compiling=yes install_root=${STAGING_DIR_HOST} \
	includedir='${layout_includedir}' prefix='${layout_prefix}' install-headers

}

do_install () {
	:
}
