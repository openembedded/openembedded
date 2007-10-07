# Bitbake recipe for the madwifi-ng driver

# Don't use this unless you know what you're doing -- this version does
# *NOT* build on BE kernels.
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_alix = "1"

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

# PR set after the include, to override what's set in the included file.
PR = "r0"
