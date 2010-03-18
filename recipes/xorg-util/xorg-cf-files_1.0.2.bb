require xorg-util-common.inc

DESCRIPTION = "X Window System CF files"

PR = "r1"
PE = "1"

FILES_${PN} += " /usr/lib/X11/config"
SRC_URI[archive.md5sum] = "f96f44b87132afd2fff677a8c89166dd"
SRC_URI[archive.sha256sum] = "4edcaf61ad8b4bef65169af2b98d3992be07260f90cca65128dc523d6935bdd8"
