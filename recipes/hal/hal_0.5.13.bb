require hal.inc

DEFAULT_PREFERENCE = "-1"

# The following code finds the right linux/input.h,
# which also works with external-toolchain/SDK
do_configure() {
	sed -i -e s:1.43:1.41:g ${S}/configure.in
	linux_input_h=`echo "#include <linux/input.h>" | ${CPP} - | \
		grep "linux\/input.h" | head -n 1 | awk -F '"' '{print $2}'`
	autotools_do_configure --with-linux-input-header=${linux_input_h}
}

SRC_URI[md5sum] = "46ecc5d2e5bd964fb78099688f01bb6a"
SRC_URI[sha256sum] = "ebcf22a373761530920643add1a791af40954dc7349f027d1c35b0e0f7f9c8af"
