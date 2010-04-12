DESCRIPTION = "Webcam imaage grabber and manipulation application."
SECTION = "graphics"
DEPENDS = "gd"
LICENSE = "GPL"

PR = "r0"

inherit autotools

SRC_URI = "http://www.firestorm.cx/fswebcam/files/${P}.tar.gz"

SRC_URI[md5sum] = "f7619566779f4484d3acd806cdc30f5f"
SRC_URI[sha256sum] = "82dd976a64919383aabccf760257bcef52621e428b0af922a7d4886b54477937"
