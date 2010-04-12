require hal.inc

PR = "r6"

SRC_URI += " file://hal-right-input-h.patch;patch=1 \
             file://fix-configure.diff;patch=1 \
             file://wifi-2.6.27.diff;patch=1"

# The following code finds the right linux/input.h,
# which also works with external-toolchain/SDK
do_configure() {
	linux_input_h=`echo "#include <linux/input.h>" | ${CPP} - | \
		grep "linux\/input.h" | head -n 1 | awk -F '"' '{print $2}'`
	autotools_do_configure --with-linux-input-header=${linux_input_h}
}

SRC_URI[md5sum] = "750cf074e88b6fb7012f26d99cd39b9b"
SRC_URI[sha256sum] = "730a9f2340f789677eb0c3b0984bbaca3ede6c12d1e4b16bc7ea91f51d10ba90"
