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

SRC_URI[md5sum] = "2c7352cbbdac995de8c3bce5b80db5f2"
SRC_URI[sha256sum] = "0599c75b95ba63bdc554cb8124192e62c75fbeb71b9e8a5a7bc351c8e0666758"
