SECTION = "libs"
DEPENDS = "linux-libc-headers virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"

PACKAGES = ""
PACKAGES_DYNAMIC = ""

do_configure () {
	sed -ie 's,{ (exit 1); exit 1; }; },{ (exit 0); }; },g' ${S}/configure
	chmod +x ${S}/configure
        (cd ${S} && gnu-configize) || die "failure in running gnu-configize"
        find ${S} -name "configure" | xargs touch
	${S}/configure --host=${TARGET_SYS} --build=${BUILD_SYS} \
		--prefix=/usr \
		--without-cvs --disable-sanity-checks \
		--with-headers=${STAGING_DIR_TARGET}${layout_includedir} \
		--enable-hacker-mode --enable-addons
}

do_compile () {
	:
}

do_stage () {
	oe_runmake cross-compiling=yes install_root=${STAGING_DIR_HOST} \
	includedir='${layout_includedir}' prefix='${layout_prefix}' install-headers \
	install-bootstrap-headers=yes
        oe_runmake csu/subdir_lib

        mkdir -p ${STAGING_DIR_TARGET}${layout_libdir}
        install -m 644 csu/crt[1in].o ${STAGING_DIR_TARGET}${layout_libdir}
        ${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
                       -o ${STAGING_DIR_TARGET}${layout_libdir}/libc.so
}

do_install () {
	:
}
