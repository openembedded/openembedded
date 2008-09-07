# Bitbake recipe for the madwifi-ng driver

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

# Due to a minor Makefile restructuring, newer versions require an updated
# patch; this is really ugly and some alternate way to do this that's more
# generic should be figured out.
WACKELF_SRC_URI_ixp4xx =          " file://20-xscale-VFP-wackelf-v2.patch;patch=1"
WACKELF_SRC_URI_compulab-pxa270 = " file://20-xscale-VFP-wackelf-v2.patch;patch=1"

SRCNAME = "madwifi-trunk"

# PR set after the include, to override what's set in the included file.
PR = "r1"
