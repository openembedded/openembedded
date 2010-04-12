# Bitbake recipe for the madwifi-ng driver

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_alix = "1"
DEFAULT_PREFERENCE_mpc8323e-rdb = "1"

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

# PR set after the include, to override what's set in the included file.
PR = "r1"

SRC_URI[md5sum] = "fe1758398de89fce57f05f9c1d1bb923"
SRC_URI[sha256sum] = "70cfa5eacd27d46a5e6f562b01769c64794d20ce4636cf133def7db7f0715efb"
