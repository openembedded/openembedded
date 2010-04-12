DESCRIPTION = "VTE-based terminal emulator"
AUTHOR = "David Gómez Espinosa <david@pleyades.net>"
HOMEPAGE = "http://www.pleyades.net/david/sakura.php"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "gtk+ (>=2.6) vte (>=0.11)"

SRC_URI = "http://www.pleyades.net/david/projects/sakura/sakura-${PV}.tar.bz2"

inherit cmake


SRC_URI[md5sum] = "37ef8dee0b01107fc31ad3683af5572d"
SRC_URI[sha256sum] = "aa053f8b561a1ce50955d72a7b0e2145178edca9cff40ab2e6e8f1d71cac9d6b"
