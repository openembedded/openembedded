inherit canadian-native autotools

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "virtual/${TARGET_PREFIX}gcc-initial mingw-w32api"

PROVIDES = "virtual/${TARGET_PREFIX}libc virtual/${TARGET_PREFIX}libc-for-gcc"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mingw32 = "1"

PACKAGES = ""

B = "${WORKDIR}/build-${TARGET_SYS}"

do_configure() {
	oe_runconf
}
