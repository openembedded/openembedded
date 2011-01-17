require hal.inc

SRC_URI = "git://anongit.freedesktop.org/hal/;protocol=git \
        file://0001-Add-touchscreen-option.patch \
        file://20hal \
        file://99_hal"

SRCREV = "0763f4900a32ac01d4b259fe010ab8ebfc83ad0f"

PV = "0.5.14"
PR = "${INC_PR}.2"
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
