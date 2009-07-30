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
