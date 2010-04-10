SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"


LICENSE = "GPL"
DEPENDS = "libopensync"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig



SRC_URI[md5sum] = "d55d8eaeecb825b87a25eeceaef92cb9"
SRC_URI[sha256sum] = "c1454fdf5d3658f492253106c12bbf89a3bcc5789c36851a5f2f345d61a4ac0c"
