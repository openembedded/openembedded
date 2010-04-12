LICENSE     = "GPL"
DESCRIPTION = "A cellphone status panel to be used with gpe-applauncher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpephone dbus-glib"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/themes"

SRC_URI[md5sum] = "2c60de78f2e539ea242c4ba891d3e5ed"
SRC_URI[sha256sum] = "4b1e77ff0a5a74165bae6e842f122fc17a6331e0566a2b83d1ad8ac3ef5fe4b8"
