# Bitbake recipe for the madwifi-ng driver

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

SRC_URI += " \
	file://30-define-ioreadwrite32be-for-little-endian-too.patch;patch=1 \
	"

# PR set after the include, to override what's set in the included file.
PR = "r6"
