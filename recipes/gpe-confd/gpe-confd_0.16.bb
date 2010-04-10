inherit gpe

DEPENDS = "libxsettings glib-2.0 sqlite"
SECTION = "gpe"
DESCRIPTION = "GPE configuration daemon"
LICENSE = "GPL"
PR = "r1"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "2677260df7d834ec416450e09ae5ba72"
SRC_URI[sha256sum] = "9ffba12d92466f9e34fed21e38baae5cbb6608436ee53fa3704fe3be5fceb4af"
