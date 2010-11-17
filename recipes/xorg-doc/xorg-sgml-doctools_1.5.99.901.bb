require xorg-doc-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6c415566a88f787261bcde73440e5ef0"
SRC_URI[archive.sha256sum] = "fbd657ecb27d4f74b997aa44e85c22727cd383497978cc683e5b4dadbb472056"

FILES_${PN} += " /usr/share/sgml/X11"
