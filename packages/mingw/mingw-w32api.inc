inherit canadian-native autotools

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "virtual/${TARGET_PREFIX}gcc-initial"

PROVIDES = "mingw-w32api"

DEFAULT_PREFERENCE = "0"
DEFAULT_PREFERENCE_sdk-mingw32 = "1"

PACKAGES = ""

B = "${WORKDIR}/build-${TARGET_SYS}"
