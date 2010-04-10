require hal.inc

DEFAULT_PREFERENCE = "-1"

PR = "r1"

# The following code finds the right linux/input.h,
# which also works with external-toolchain/SDK
do_configure() {
	sed -i -e s:1.43:1.41:g ${S}/configure.in
	linux_input_h=`echo "#include <linux/input.h>" | ${CPP} - | \
		grep "linux\/input.h" | head -n 1 | awk -F '"' '{print $2}'`
	autotools_do_configure --with-linux-input-header=${linux_input_h}
}

SRC_URI[md5sum] = "bb7c36e142437f7363f9a80ae8391926"
SRC_URI[sha256sum] = "c444e0485e4361eec0e6f06580c45b9fcf6f20a119634a5f0a5c13218cfdfd02"
