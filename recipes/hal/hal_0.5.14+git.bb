require hal.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "git://anongit.freedesktop.org/hal/;protocol=git \
        file://0001-Add-touchscreen-option.patch;patch=1 \
        file://20hal \
        file://99_hal"

SRCREV = "6dccf8e3ad181e8f56b1d2a994ec50a1953a1c2d"

PV = "0.5.14"
PR = "r2"
PR_append = "+gitr${SRCREV}"

S = "${WORKDIR}/git"

# The following code finds the right linux/input.h,
# which also works with external-toolchain/SDK
do_configure() {
	sed -i -e s:1.43:1.41:g ${S}/configure.in
	linux_input_h=`echo "#include <linux/input.h>" | ${CPP} - | \
		grep "linux\/input.h" | head -n 1 | awk -F '"' '{print $2}'`
	autotools_do_configure --with-linux-input-header=${linux_input_h}
}
