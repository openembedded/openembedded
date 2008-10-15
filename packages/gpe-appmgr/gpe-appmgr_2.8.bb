DESCRIPTION = "GPE application launcher"
DEPENDS = "libgpewidget libgpelaunch cairo libxsettings-client"
SECTION = "gpe"
LICENSE = "GPL"
FILE_PR = "r1"

inherit gpe

SRC_URI += " file://no-render-h.patch;patch=1 file://cairo-fixes.patch;patch=1"
