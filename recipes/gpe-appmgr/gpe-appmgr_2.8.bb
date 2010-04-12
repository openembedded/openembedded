DESCRIPTION = "GPE application launcher"
DEPENDS = "libgpewidget libgpelaunch cairo libxsettings-client"
SECTION = "gpe"
LICENSE = "GPL"
PR = "r1"

inherit gpe

SRC_URI += " file://no-render-h.patch;patch=1 file://cairo-fixes.patch;patch=1"

SRC_URI[md5sum] = "2dd3d56eee8905451e9c31cfda620f7a"
SRC_URI[sha256sum] = "1a797188e9786936c32fee6ba3e20f01d562583f6407cf8d83f729ab708e1342"
