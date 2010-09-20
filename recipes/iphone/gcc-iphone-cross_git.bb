DESCRIPTION = "GCC for iPhone"
DEPENDS = "iphone-sdks"
PV = "4.2.1+git${SRCREV}"

INHIBIT_DEFAULT_DEPS = "1"
COMPATIBLE_MACHINE = "(iphone)"

PROVIDES = "virtual/${TARGET_PREFIX}gcc virtual/${TARGET_PREFIX}g++"
PROVIDES += "virtual/${TARGET_PREFIX}gcc-initial virtual/${TARGET_PREFIX}gcc-intermediate"
DEPENDS = "virtual/${TARGET_PREFIX}binutils bison-native flex-native iphone-rootfs"

SRCREV = "b3dd8400196ccb63fbf10fe036f9f8725b2f0a39"
SRC_URI = "git://git.saurik.com/llvm-gcc-4.2.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools cross

EXTRA_OECONF = "\
	--enable-languages=c,c++,objc,obj-c++ \
	--enable-sjlj-exceptions \
	--enable-wchar_t=no  \
	--with-gxx-include-dir=${STAGING_DIR_TARGET}/${layout_includedir}/c++ \
	--with-as=${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}as \
	--with-ld=${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}ld \
	--with-sysroot=${STAGING_DIR_TARGET} \
	--with-build-sysroot=${STAGING_DIR_TARGET} \
	--with-local-prefix=${STAGING_DIR_TARGET}${layout_prefix} \
	"

do_configure() {
	oe_runconf
	rm -f GNUmakefile
}

