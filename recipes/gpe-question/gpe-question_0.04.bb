LICENSE = "GPL"
inherit gpe

SRC_URI += "file://makefile-fix.patch"

DEPENDS = "libgpewidget"
RDEPENDS_${PN} = "gpe-icons"
SECTION = "gpe"
DESCRIPTION = "GPE interface for asking questions from shell scripts"
PR = "r1"

SRC_URI[md5sum] = "8187ca6f6e5da27a3b224469a3cbb76d"
SRC_URI[sha256sum] = "14fb095d231343a576da5e8aa7807b09cd7bde2df59a5a569495dc03a434d178"
