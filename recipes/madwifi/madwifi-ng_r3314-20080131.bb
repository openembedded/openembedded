# Bitbake recipe for the madwifi-ng driver

require madwifi-ng_r.inc

SRC_URI += " \
	file://30-define-ioreadwrite32be-for-little-endian-too.patch \
	"

# PR set after the include, to override what's set in the included file.
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "2c7352cbbdac995de8c3bce5b80db5f2"
SRC_URI[sha256sum] = "0599c75b95ba63bdc554cb8124192e62c75fbeb71b9e8a5a7bc351c8e0666758"
