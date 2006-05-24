LICENSE = "GPL"
PR = "r1"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "ipkg libgpewidget"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

pkg_postinst () {
#!/bin/sh
chmod u+s /usr/bin/gpe-package
}
