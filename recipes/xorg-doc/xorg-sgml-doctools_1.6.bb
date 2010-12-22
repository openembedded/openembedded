require xorg-doc-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "fe333413fd4139de07ebfa36039b8a59"
SRC_URI[archive.sha256sum] = "98d20476e8a3e413c9597a94c9a578768afb28211c0d030dc7b8256055d5ae6a"

FILES_${PN} += " /usr/share/sgml/X11"
