require xorg-doc-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1cd2d8213ee71ebdbefce45c9da54762"
SRC_URI[archive.sha256sum] = "0e135d7c848d8b740df71895aa00ed8354406979e01f0df50a243fcd46452e20"

FILES_${PN} += " /usr/share/sgml/X11"
