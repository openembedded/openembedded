require hal.inc

DEFAULT_PREFERENCE = "-1"

# The following code finds the right linux/input.h,
# which also works with external-toolchain/SDK
do_configure() {
	linux_input_h=`echo "#include <linux/input.h>" | ${CPP} - | \
		grep "linux\/input.h" | head -n 1 | awk -F '"' '{print $2}'`
	autotools_do_configure --with-linux-input-header=${linux_input_h}
}
